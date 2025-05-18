from classes.Salon import Salon

class Pareja(Salon):
    def __init__(self, nombre, capacidad=2, precio_base=50):
        super().__init__(nombre, "Romántica", capacidad, precio_base)
        self._flores = True
        self._velas = True

    @property
    def precio_reserva(self):
        # Precio base + 10% por servicios románticos
        return self._precio_base * 1.10

    @property
    def incluye_flores(self):
        return self._flores

    @property
    def incluye_velas(self):
        return self._velas

    def __str__(self):
        base_str = super().__str__()
        return f"{base_str} - Mesa Romántica (Incluye: {'Flores y velas' if self._flores and self._velas else 'Ninguno'})"