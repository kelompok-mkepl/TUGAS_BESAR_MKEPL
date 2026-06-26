# DUML (Diagram Master)

## Deskripsi Project

DUML (Diagram Master) adalah aplikasi berbasis Java yang digunakan untuk membantu pengguna dalam membuat beberapa jenis diagram UML secara sederhana melalui antarmuka console. Aplikasi ini mendukung pembuatan beberapa diagram seperti:

- Activity Diagram
- Use Case Diagram
- Sequence Diagram
- Class Diagram

Project ini dikembangkan sebagai tugas mata kuliah dengan menerapkan konsep Continuous Integration (CI), Continuous Testing (CT), Continuous Inspection, dan Continuous Delivery (CD) menggunakan GitHub Actions.

---

## Teknologi yang Digunakan

- Java 17
- Maven
- JUnit 5
- Git
- GitHub
- GitHub Actions
- SonarCloud
- IntelliJ IDEA

---

## Struktur Project

DUML
│
├── .github
│   └── workflows
│       └── ci-cd.yml
│
├── src
│   ├── main
│   │   └── java
│   │       └── ...
│   │
│   └── test
│       └── java
│           └── ...
│
├── pom.xml
└── README.md


---

## Branching Strategy

Project menggunakan Git Flow sederhana.

```
main
│
└── dev
    ├── feature/maven-ci
    ├── feature/unit-test
    ├── feature/sonarcloud
    └── feature/deployment-readme


Keterangan:

- **main** : Branch production/final.
- **dev** : Branch integrasi seluruh anggota.
- **feature/** : Branch pekerjaan masing-masing anggota.

Seluruh perubahan dilakukan pada feature branch, kemudian di-merge ke branch dev melalui Pull Request. Setelah seluruh fitur selesai dan pipeline berhasil, branch dev di-merge ke branch main.

---

## CI/CD Pipeline

Pipeline GitHub Actions terdiri dari lima tahapan.

### 1. Continuous Integration (Build)

Melakukan:

- Checkout repository
- Setup Java 17
- Build project menggunakan Maven
- Menghasilkan artifact (.jar)

---

### 2. Continuous Testing

Menjalankan unit testing menggunakan JUnit.

Perintah:


mvn test

---

### 3. Continuous Inspection

Melakukan analisis kualitas kode menggunakan SonarCloud.

Analisis meliputi:

- Code Smells
- Bugs
- Vulnerabilities
- Maintainability

---

### 4. Continuous Delivery (Staging)

Artifact hasil build diunduh dan dipersiapkan pada environment staging.

---

### 5. Continuous Delivery (Production)

Deployment menuju production dilakukan setelah mendapatkan approval reviewer melalui GitHub Environment Protection Rules.

---

## Cara Menjalankan Project

Clone repository.

bash
git clone https://github.com/USERNAME/DUML.git


Masuk ke folder project.

bash
cd DUML


Build project.

bash
mvn clean package


Menjalankan aplikasi.

bash
java -jar target/DiagramMaster-1.0-SNAPSHOT.jar


Menjalankan unit test.

bash
mvn test


---

## Workflow Pengembangan

1. Clone repository.
2. Checkout ke branch dev.
3. Membuat feature branch.
4. Melakukan pengembangan.
5. Commit perubahan.
6. Push ke feature branch.
7. Membuat Pull Request menuju dev.
8. Setelah seluruh feature selesai, dev di-merge ke main.
9. GitHub Actions menjalankan pipeline CI/CD secara otomatis.

---

## Pembagian Tugas

| Anggota | Tugas |
|----------|-------|
| Anggota 1 | Setup Maven, pom.xml, Build Pipeline |
| Anggota 2 | Unit Testing menggunakan JUnit |
| Anggota 3 | Continuous Inspection menggunakan SonarCloud |
| Anggota 4 | Deployment Staging, Production Approval, Dokumentasi README |

---

## Pipeline

Pipeline terdiri atas tahapan berikut.

Build
   │
   ▼
Unit Test
   │
   ▼
SonarCloud Inspection
   │
   ▼
Deploy Staging
   │
   ▼
Production Approval
   │
   ▼
Deploy Production


---

## Hasil Pipeline

Pipeline akan berjalan otomatis ketika terjadi:

- Push ke branch dev
- Push ke branch main
- Pull Request menuju main

Status pipeline dapat dilihat pada tab **GitHub Actions**.
