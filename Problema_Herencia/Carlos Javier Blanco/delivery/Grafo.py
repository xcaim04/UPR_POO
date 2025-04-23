from Repartidor import *

class GrafoCiudad:

    def __init__(self, archivo):
        self.nodos = {}
        self._cargar_grafo(archivo)

    def _cargar_grafo(self, archivo):
        with open(archivo, 'r') as f:
            for line in f:
                origen, destino, tiempo = line.strip().split(',')
                self.agregar_calle(origen, destino, float(tiempo))
                self.agregar_calle(destino, origen, float(tiempo))

    def agregar_calle(self, origen, destino, tiempo):
        if origen not in self.nodos:
            self.nodos[origen] = {}
        self.nodos[origen][destino] = tiempo

if __name__ == '__main__':

    Ciudad = GrafoCiudad('grafo_ciudad.txt')

    flota = [
        Drone(101, "A"),
        Moto(201, "B"),
        Moto(202, "D")
    ]

    casos = [
        # (origen, destino, tipo, peso, urgencia)
        ("A", "G", "medicina", 1.5, 5),
        ("B", "H", "paquete", 10, 3),
        ("D", "E", "comida", 3, 2),
        ("C", "G", "electronico", 1, 4)
    ]

    for i, (origen, destino, tipo, peso, urgencia) in enumerate(casos, 1):
        print(f"\n--- Caso {i}: {tipo} de {origen} a {destino} ---")
        pedido = Pedido(i, origen, destino, tipo, peso, urgencia)
        
        for repartidor in flota:
            if repartidor.estado == EstadoRepartidor.LIBRE and repartidor.puede_llevar(pedido):
                repartidor.asignar_pedido(pedido, Ciudad)
                print(f"🛵 Asignado a {repartidor.__class__.__name__} {repartidor.id}")
                print(f"   Ruta: {repartidor.ruta_actual}")
                print(f"   Tiempo estimado: {repartidor.tiempo_ocupado:.1f} mins")
                break
        else:
            print("❌ No hay repartidores disponibles para este pedido")

