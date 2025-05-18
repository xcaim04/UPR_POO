from classes.Salon import Salon

class Familiar(Salon):
    def __init__(self, nombre, capacidad=8, precio_base=100):
        super().__init__(nombre, "Familiar", capacidad, precio_base)
        self._juegos_infantiles = True

    @property
    def precio_reserva(self):
        # Descuento del 5% para mesas familiares
        return self._precio_base * 0.5

    @property
    def tiene_juegos_infantiles(self):
        return self._juegos_infantiles

    def __str__(self):
        base_str = super().__str__()
        return f"{base_str} - Área infantil: {'Sí' if self._juegos_infantiles else 'No'}"