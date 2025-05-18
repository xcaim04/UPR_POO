from abc import ABC, abstractmethod

class Salon(ABC):
    def __init__(self, nombre, tipo_mesa, capacidad, precio_base):
        self._nombre = nombre
        self._tipo_mesa = tipo_mesa
        self._capacidad = capacidad
        self._precio_base = precio_base

    @property
    def nombre(self):
        return self._nombre

    @property
    def tipo_mesa(self):
        return self._tipo_mesa

    @tipo_mesa.setter
    def tipo_mesa(self, nuevo_tipo):
        self._tipo_mesa = nuevo_tipo

    @property
    def capacidad(self):
        return self._capacidad

    @capacidad.setter
    def capacidad(self, nueva_capacidad):
        if nueva_capacidad > 0:
            self._capacidad = nueva_capacidad
        else:
            raise ValueError("La capacidad debe ser positiva")

    @property
    def precio_base(self):
        return self._precio_base

    @precio_base.setter
    def precio_base(self, nuevo_precio):
        if nuevo_precio >= 0:
            self._precio_base = nuevo_precio
        else:
            raise ValueError("El precio no puede ser negativo")

    @property
    @abstractmethod
    def precio_reserva(self):
        pass

    def __str__(self):
        return f"{self._nombre} - Mesa {self._tipo_mesa} (Capacidad: {self._capacidad})"