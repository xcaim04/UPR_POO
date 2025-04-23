import heapq
from abc import ABC, abstractmethod
from enum import Enum

class EstadoRepartidor(Enum):
    LIBRE = 1
    EN_CAMINO = 2

class TipoTransporte(Enum):
    DRONE = 1
    MOTO = 2

class Pedido:

    def __init__(self, id, origen, destino, tipo, peso, urgencia):
        self.id = id
        self.origen = origen
        self.destino = destino
        self.tipo = tipo
        self.peso = peso
        self.urgencia = urgencia # 1 - 5

class Repartidor(ABC):

    def __init__(self, id, ubicacion):

        self.id = id
        self.ubicacion = ubicacion
        self.estado = EstadoRepartidor.LIBRE
        self.pedidos = []
        self.ruta_actual = []
        self.tiempo_ocupado = 0

        @abstractmethod
        def calcular_ruta(self, grafo):
            pass

        @abstractmethod
        def puede_llevar(self, pedido):
            pass

    def asignar_pedido(self, pedido, grafo):
        if self.puede_llevar(pedido):
            self.pedidos.append(pedido)
            self.calcular_ruta(grafo, pedido)
            self.estado = EstadoRepartidor.EN_CAMINO
            return True
        return False

class Drone(Repartidor):

    def __init__(self, id, ubicacion):
        super().__init__(id, ubicacion)
        self.peso_maximo = 2
        self.velocidad = 1.2

    def calcular_ruta(self, grafo, pedido):
        if self.pedidos:
            self.ruta_actual = [self.ubicacion, self.pedidos[0].destino]
            self.tiempo_ocupado = len(self.ruta_actual) * self.velocidad

    def puede_llevar(self, pedido):
        return (pedido.peso <= self.peso_maximo and pedido.tipo != 'electronico')

class Moto(Repartidor):

    def __init__(self, id, ubicacion):
        super().__init__(id, ubicacion)
        self.peso_maximo = 15
        self.velocidad = 0.9

    def puede_llevar(self, pedido):
        return (pedido.peso <= self.peso_maximo)

    def calcular_ruta(self, grafo, pedido):
        # Verificación más adecuada del pedido
        if pedido is None:
            return

        origen = self.ubicacion
        destino = pedido.destino

        # Inicialización de estructuras
        distancia = {nodo: float('inf') for nodo in grafo.nodos}
        distancia[origen] = 0
        previo = {nodo: None for nodo in grafo.nodos}
        
        cola = [(0, origen)]
        visitados = set()

        while cola:
            costo, nodo = heapq.heappop(cola)

            if nodo == destino:
                break

            if nodo in visitados:
                continue
                
            visitados.add(nodo)

            for vecino, tiempo in grafo.nodos.get(nodo, {}).items():
                costo_nuevo = costo + tiempo
                if costo_nuevo < distancia[vecino]:
                    distancia[vecino] = costo_nuevo
                    previo[vecino] = nodo
                    heapq.heappush(cola, (costo_nuevo, vecino))

        # Reconstrucción correcta del camino
        camino = []
        nodo_actual = destino
        while nodo_actual is not None:
            camino.append(nodo_actual)
            nodo_actual = previo[nodo_actual]
        camino.reverse()

        if not camino or camino[0] != origen:
            return  # No se encontró camino

        self.ruta_actual = camino
        
        # Manejo seguro de velocidad
        if self.velocidad <= 0:
            raise ValueError("La velocidad debe ser mayor que cero")
        
        self.tiempo_ocupado += distancia[destino] / self.velocidad
