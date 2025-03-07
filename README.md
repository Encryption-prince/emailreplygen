# 📧 Email Reply Generator

Effortlessly generate professional and context-aware email replies using the power of AI! 🚀 This backend service utilizes **Spring Boot, REST API and the Gemini API** to generate smart responses, making email management smoother and more efficient.

🔗 **Live Demo:** [Click Here](ai-powered-mail-reply-generator.vercel.app)   
🦊 **Firefox Extension:** [Install Now](https://addons.mozilla.org/en-US/firefox/addon/email-reply-generator/?utm_source=addons.mozilla.org&utm_medium=referral&utm_content=search)

---

## ⚡ Features
✅ AI-powered email reply generation using **Gemini API**  
✅ RESTful API for seamless integration  
✅ Fast and scalable backend with **Spring Boot**  
✅ Easy to integrate with gmail  

---

## 🛠️ Technologies Used
- **Spring Boot** - For backend development  
- **REST API** - To provide seamless communication  
- **Gemini API** - AI-powered email response generation  
---

## 🎨 Frontend Repository
The frontend code for this project is available separately. You can find it here:  
🔗 [Frontend Repository](https://github.com/SahilShaw2004/Ai-powered-Mail-Reply-Generatorx) by **Sahil Shaw**

---

## 🚀 Getting Started
### 🔧 Prerequisites
Ensure you have the following installed:
- Java 17  
- Maven  
- A valid API key for **Gemini API**  

### 🔥 Installation & Running
```bash
# Clone the repository
git clone <repo-link>
cd emailreplygen

# Build and run the project
mvn spring-boot:run
```

### 🛠 API Usage
Send a `POST` request to the API endpoint with your email content:
```bash
POST localhost:8080/api/email/generate
Content-Type: application/json
{
  "emailContent": "Your email content here",
  "tone" : "Your Tone here"
}
```
The response will contain an AI-generated email reply.

---

## 📌 Contributing
We welcome contributions! Feel free to fork the repo and submit a PR. 🚀

---

## 📜 License
This project is licensed under the **MIT License**.

---

🌟 **Enjoy seamless email replies with AI!** 🌟
