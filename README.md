# 💬 Chat App

![Kotlin](https://img.shields.io/badge/Kotlin-2.0+-blue.svg?logo=kotlin)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-Material%203-4285F4.svg?logo=android)
![Insets](https://img.shields.io/badge/Window%20Insets-Edge--to--Edge-success.svg)

Aplicación de mensajería nativa enfocada en la resolución de uno de los desafíos más complejos en el desarrollo móvil: **la gestión perfecta del teclado en pantalla (IME)** y el renderizado eficiente de listas invertidas en tiempo real.

## 📱 Capturas de pantalla y video

| Pantalla 1 | Pantalla 2 |
| :---: | :---: |
| <img src="/assets/scr01.jpeg" width="250"/> | <img src="/assets/scr03.jpeg" width="250"/> |

| Pantalla 3 | Pantalla 4 |
| :---: | :---: |
| <img src="/assets/scr02.jpeg" width="500"/> | <img src="/assets/scr04.jpeg" width="500"/> |

## ✨ Características Principales

* **Gestión de Teclado Fluida:** Uso avanzado de `WindowInsets` (`imePadding`, `navigationBarsPadding`) para empujar la interfaz sincronizadamente con la aparición del teclado virtual.
* **Listas de Alto Rendimiento:** Implementación de `LazyColumn(reverseLayout = true)` para renderizar mensajes desde la parte inferior, optimizando la inserción de nuevos elementos en el índice 0 sin recalcular todo el árbol.
* **Auto-Scroll Reactivo:** Efectos secundarios (`LaunchedEffect`) anclados al tamaño de la lista para desplazar automáticamente la vista hacia el mensaje más reciente de forma animada.
* **Diseño Edge-to-Edge:** Barra de estado y navegación transparentes que permiten que el contenido del chat fluya por toda la pantalla, con un `TopAppBar` semitransparente.

## 🛠️ Stack Tecnológico

* **Lenguaje:** [Kotlin](https://kotlinlang.org/)
* **UI Toolkit:** [Jetpack Compose](https://developer.android.com/jetpack/compose)
* **Arquitectura de UI:** Componentes aislados y manejo de estado local (`StateFlow` / `mutableStateListOf`).
* **Sistema de Diseño:** Material Design 3 (Formas asimétricas, elevación tonal).

## 🚀 Instalación y Configuración

1. **Clona el repositorio:**
   ```bash
   git clone https://github.com/JHugoVelarde/chat.git)
   ```

2. Ejecuta el proyecto:
- Abre el proyecto en Android Studio.
- Selecciona un emulador o dispositivo físico y presiona Run.
- Prueba a tocar el campo de texto para ver la animación fluida del teclado empujando la lista.

## 📂 Estructura del Proyecto

```
com.example.chatapp
│
├── data/                   # Simulación de datos
│   └── Message.kt          # Modelo de datos y FakeData
│
└── ui/                     # Capa de presentación
    ├── components/         # Componentes atómicos
    │   ├── ChatBubble.kt   # Burbujas de chat asimétricas
    │   ├── MessageInput.kt # Campo de texto con insets
    │   └── ConversationTopBar.kt # Cabecera semitransparente
    ├── screens/            # Ensamblaje de vistas
    │   └── ConversationScreen.kt # Orquestación de LazyColumn
    └── theme/              # Tema dinámico Material 3
```

## 💡 Lecciones Clave de Arquitectura y UI
- reverseLayout es vital: Invertir visualmente un LazyColumn es drásticamente más eficiente en recursos que forzar a la lista a hacer scroll hacia el final (scrollToItem(list.size - 1)) cada vez que la UI se redibuja.
- Insets como modificadores: La separación de statusBarsPadding() en la cabecera y imePadding() en el pie de la pantalla demuestra un control granular sobre el área segura del dispositivo, logrando un Edge-to-Edge profesional.
- Formas Dinámicas: El uso de RoundedCornerShape condicional para las burbujas de chat crea una jerarquía visual clara y moderna sin depender de recursos XML (9-patch images) heredados.

## 📄 Licencia

Este proyecto está licenciado bajo la Licencia Apache 2.0 - consulta el archivo [LICENSE](LICENSE) para más detalles.
