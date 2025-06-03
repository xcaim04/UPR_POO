from flask import Flask, render_template, request, redirect, url_for
from classes.Parejas import Pareja
from classes.VIP import VIP
from classes.Familiar import Familiar
from datetime import datetime

from flask import flash, redirect, url_for

import re

app = Flask(__name__)
app.secret_key = 'PanConPerro1234*@'

mesas_disponibles = [
    Pareja("Mesa Romántica 1"),
    Pareja("Mesa Romántica 2", precio_base=60),
    VIP("Mesa VIP 1", capacidad=4),
    VIP("Mesa VIP 2", capacidad=8, precio_base=200),
    Familiar("Mesa Familiar 1"),
    Familiar("Mesa Grande", capacidad=12, precio_base=150)
]

reservas = []

@app.route('/')
def home():
    return render_template('home.html', mesas=mesas_disponibles)

@app.route('/reservar', methods=['GET', 'POST'])
def reservar():
    if request.method == 'POST':
        nombre = request.form['nombre']
        email = request.form['email']
        fecha = request.form['fecha']
        hora = request.form['hora']
        personas = int(request.form['personas'])
        mesa_id = int(request.form['mesa'])


        if not nombre.strip() or not re.fullmatch('^[a-zA-ZáéíóúñÁÉÍÓÚÑ\s]+$', nombre):
            flash('❌ Nombre invalido', 'error')
            return redirect(url_for('reservar'))

        patron = r'^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$'
        if not re.match(patron, email):
            flash('❌ Email invalido', 'error')
            return redirect(url_for('reservar'))

        anio = int(fecha.split('-')[0])

        if anio != datetime.now().year:
            flash('❌ Fecha invalida', 'error')
            return redirect(url_for('reservar'))

        if mesa_id < 0 or mesa_id >= len(mesas_disponibles):
            flash('❌ Mesa invalida', 'error')
            return redirect(url_for('reservar'))

        mesa = mesas_disponibles[mesa_id]

        if personas > mesa.capacidad:
            flash('❌ Esta mesa solo tiene capacidad para {mesa.capacidad} personas', 'error')
            return redirect(url_for('reservar'))

        reserva = {
            'id': len(reservas) + 1,
            'nombre': nombre,
            'email': email,
            'fecha': fecha,
            'hora': hora,
            'personas': personas,
            'mesa': mesa.nombre,
            'tipo_mesa': mesa.tipo_mesa,
            'precio': mesa.precio_reserva,
            'fecha_reserva': datetime.now().strftime("%Y-%m-%d %H:%M:%S")
        }

        reservas.append(reserva)
        mesas_disponibles.remove(mesa)
        return redirect(url_for('confirmacion', reserva_id=reserva['id']))

    return render_template('reservar.html', mesas=mesas_disponibles)


@app.route('/confirmacion/<int:reserva_id>')
def confirmacion(reserva_id):
    reserva = next((r for r in reservas if r['id'] == reserva_id), None)
    if not reserva:
        return "Reserva no encontrada", 404
    return render_template('confirmacion.html', reserva=reserva)


if __name__ == '__main__':
    app.run(debug=True)