from classes.Salon import Salon


class VIP(Salon):
    def __init__(self, nombre, capacidad=6, precio_base=150):
        super().__init__(nombre, "VIP", capacidad, precio_base)
        self._servicios_extra = ["Atención personalizada", "Menú exclusivo"]

    @property
    def precio_reserva(self):
        # Precio base + 20% por servicios VIP
        return self._precio_base * 1.20

    @property
    def servicios_extra(self):
        return self._servicios_extra.copy()

    def agregar_servicio(self, servicio):
        self._servicios_extra.append(servicio)

    def __str__(self):
        base_str = super().__str__()
        servicios = ", ".join(self._servicios_extra)
        return f"{base_str} - Servicios VIP: {servicios}"