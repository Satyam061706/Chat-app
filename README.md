# 💬 SocketChat: Real-Time Java Messenger

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Swing](https://img.shields.io/badge/Swing-GUI-blue?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Completed-success?style=for-the-badge)

A powerful, multi-threaded desktop chat application built from the ground up using **Java Socket Programming** and **Swing GUI**. This project demonstrates bidirectional communication between a Server and a Client over a TCP/IP connection.

---

## ✨ Key Features

- **🚀 Instant Communication**: Seamless real-time message exchange.
- **🎨 Modern GUI**: A clean interface built with `JFrame`, featuring custom fonts (Roboto) and icons.
- **🧵 Concurrent Processing**: Uses Java Threads to handle incoming and outgoing streams simultaneously.
- **🛡️ Connection Management**: Robust handling of connection terminations with automatic alerts.
- **📦 Scalable Design**: Separated Server and Client logic for clear architectural understanding.

---

## 🛠️ Architecture & Tech Stack

- **Backend**: Java Standard Edition (JDK 8+)
- **Networking**: `java.net.ServerSocket`, `java.net.Socket`
- **I/O Streams**: `BufferedReader`, `PrintWriter` for efficient data handling.
- **Frontend**: Java Swing & AWT for a native desktop experience.
- **Threading**: `Runnable` interface and `Thread` class for non-blocking I/O.

---

## 📂 Project Structure

```text
chat-app/
├── 📄 Server.java       # Server-side application (Host)
├── 📄 Client.java       # Client-side application (User)
├── 📄 practice.java     # Utility/Practice code for logic testing
├── 🖼️ logo4.png         # Main application icon
├── 🖼️ logo[1-3].png     # Alternative assets
└── 📁 out/              # Compiled bytecode (.class files)
```

---

## 🚦 Getting Started

### 📋 Prerequisites
*   **Java JDK** installed on your system.
*   **Terminal/Command Prompt** access.

### 🏃 How to Run

1.  **Clone the Repository** (or navigate to the folder):
    ```bash
    cd "chat app"
    ```

2.  **Compile the Source Code**:
    ```bash
    javac Server.java Client.java
    ```

3.  **Start the Server**:
    > [!IMPORTANT]
    > Always start the Server **first** so it can listen for incoming client requests.
    ```bash
    java Server
    ```

4.  **Start the Client**:
    Open a new terminal window and run:
    ```bash
    java Client
    ```

---

## 💬 Usage Guide

- **Sending Messages**: Type your message in the bottom text field and hit **Enter**.
- **The "Exit" Protocol**: Type `exit` to gracefully close the connection. A popup alert will notify the other party of the termination.
- **Visuals**: The header displays "Server Area" or "Client Area" along with the project logo for easy identification.

---

## 📸 Preview

| Server Console | Client UI |
| :---: | :---: |
| ![Server](logo4.png) | ![Client](logo4.png) |

---

## 🤝 Contribution

Contributions, issues, and feature requests are welcome!