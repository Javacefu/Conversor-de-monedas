# Conversor de Monedas - README

## 🚀 Descripción
Conversor de monedas en Java que consulta tasas de cambio reales vía API y permite convertir entre distintas divisas de forma rápida, segura y amigable. Ideal para analistas financieros, programadores o cualquier persona que busque una herramienta sencilla pero potente en consola.

## 🔧 Características principales
*  Consulta en tiempo real a través de la API exchangerate-api.com (requiere clave personal).

*  Validación estricta de códigos de moneda (3 letras mayúsculas, ej. USD, EUR, CLP).

*  Interfaz en consola con menú claro y flujo amigable.

*  Historial de conversiones con fecha y hora, mostrado en tabla ordenada.

*  Consulta rápida de monedas disponibles en la API.

*  Manejo robusto de errores para entradas inválidas y problemas en la conexión.

*  Pausa de 3 segundos antes de volver al menú tras mostrar historial, mejorando la experiencia de usuario.

## 📂 Estructura del proyecto

| Clase                   | Función principal                                      | Última actualización |
| ----------------------- | ------------------------------------------------------ | -------------------- |
| `Main`                  | Punto de entrada, muestra menú y valida opciones       | 31 jul 2025          |
| `Menu`                  | Presenta el menú principal                             | 31 jul 2025          |
| `ValidadorOpciones`     | Controla las opciones del menú y ejecución del flujo   | 31 jul 2025          |
| `ApiCliente`            | Conecta con la API externa y parsea respuesta JSON     | 31 jul 2025          |
| `Api`                   | Maneja interacción con usuario y proceso de conversión | 31 jul 2025          |
| `ConversionApi`         | Modelo de datos para parseo JSON de la API             | 29 jul 2025          |
| `HistorialConversiones` | Almacena y muestra el historial de conversiones        | 31 jul 2025          |
| `RegistroConversion`    | Modelo para cada registro de conversión con fecha      | 31 jul 2025          |
| `Tabla`                 | Muestra los códigos de monedas disponibles             | 31 jul 2025          |


## ⚙️ Cómo usarlo

a.  Abre la clase **ApiCliente.java**.

b.  Reemplaza el valor de la variable apiKey con tu propia clave API obtenida en https://www.exchangerate-api.com/. Por ejemplo:

<img width="601" height="25" alt="image" src="https://github.com/user-attachments/assets/607472f9-6430-45cd-8ade-3d41f1b740f2" />

c.  Ejecuta la clase ***Main.java***.

d.  Selecciona la opción deseada en el menú:

1.  Ver monedas disponibles.

2.  Convertir moneda.

3.  Ver historial de conversiones.

4.  Salir.

e.  Sigue las instrucciones en consola y disfruta del conversor.

## 🔐 ¿Cómo obtener tu clave API?
1.  Visita https://www.exchangerate-api.com/.

2.  Regístrate y crea tu cuenta gratuita.

3.  Genera una nueva clave API desde el panel de usuario.

4.  Copia la clave y pégala en la variable apiKey de ApiCliente.java (ver paso 2 anterior).

## ⚠️ Advertencias
*  La clave API no debe compartirse públicamente ni subirse a repositorios sin protección.

*  Este proyecto no incluye almacenamiento persistente del historial (se guarda solo en memoria durante la ejecución).

*  Requiere conexión a internet estable para consultar la API.

## ✨ Mejoras futuras
*  Implementar lectura de clave API desde variables de entorno o archivo externo para mayor seguridad.

*  Añadir persistencia de historial en disco o base de datos.

*  Incorporar interfaz gráfica para mejorar la experiencia de usuario.

*  Mejorar manejo y registro de errores.

Contacto
Desarrollado por Javier Acevedo – Analista y programador en formación.
¿Comentarios o mejoras? ¡Estoy atento!

