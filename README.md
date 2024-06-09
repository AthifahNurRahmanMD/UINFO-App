# UINFO (University Information)
UINFO adalah sebuah aplikasi berbasis Java GUI yang dikembangkan menggunakan Gradle. Aplikasi UINFO dirancang untuk menyediakan informasi-informasi umum seputar universitas yang ada di Indonesia baik Perguruan Tinggi Negeri (PTN) maupun Perguruan Tinggi Swasta (PTS) yang sekiranya dapat dijadikan sebagai acuan untuk para pelajar dalam menentukan tempat untuk mengenyam pendidikan tingkat lanjut di perguruan tinggi.

# Group Name : UFO TEAM
1. H071231016 - Athifah Nur Rahman MD
2. H071231022 - Dhian Alifka Azzahrah
3. H071231046 - Chelsea Shelin Purnaria

# Tema yang dipilih : Books, Reference, and Education
# Nama Pendamping : Kak Muhammad Ardiansyah Asrifah
# Tim Juri : 
1. Kak Rafiq
2. Kak Fahmi

# Executive Summary
Kami memutuskan untuk membuat aplikasi mengenai informasi universitas yang ada di Indonesia. Setelah melihat data pendaftaran mahasiswa setiap tahun yang terus meningkat dan jumlah mahasiswa yang diterima di universitas-universitas di Indonesia pun mengalami peningkatan, maka kami sepakat untuk membuat aplikasi informasi universitas bernamakan UINFO. 
Aplikasi Uinfo akan menyediakan informasi-informasi umum seputar universitas yang ada di Indonesia baik Perguruan Tinggi Negeri (PTN) maupun Perguruan Tinggi Swasta (PTS) yang sekiranya dapat dijadikan sebagai acuan untuk para pelajar dalam menentukan tempat untuk mengenyam pendidikan tingkat lanjut di perguruan tinggi.

# Masalah yang ditemukan 
Aplikasi UINFO dapat membantu berbagai masalah yang sering dihadapi oleh calon  mahasiswa saat mencari informasi tentang universitas. Berikut beberapa masalah yang dapat diselesaikan:
1. Kurangnya Informasi yang terpadu mengenai universitas
2. Akses informasi mengenai alur pendaftaran ke suatu Universitas

# Solusi 
Berikut adalah beberapa solusi yang dapat ditawarkan oleh aplikasi UINFO untuk menyelesaikan masalah yang telah disebutkan:
1. Informasi terpadu terkait universitas
2. Akses yang mudah 
3. Informasi alur pendaftaran tiap universitas
4. Menyediakan informasi biaya kuliah tiap universitas
5. Menyediakan informasi terkait status yang dimiliki oleh perguruan tinggi tersebut.
6. Menyediakan diskusi antar calon mahasiswa

# Fitur Aplikasi
1. Tampilan Masuk yang menampilkan pilihan perguruan tinggi yang ada di Indonesia, yakni: Perguruan tinggi negeri dan perguruan tinggi swasta. 
2. Memberikan informasi seputar perguruan tinggi tersebut. (meliputi: biaya kuliah tunggal(yang menampilkan biaya kuliah tunggal, penggolongan ukt, juga biaya pangkal), jurusan dan fakultas yang terdapat pada perguruan tinggi tersebut, jalur pendaftaran( yang menampilkan biaya pendaftaran pada perguruan tinggi tersebut), serta menampilkan informasi status dari perguruan tinggi negeri tersebut(berbadan hukum dan non berbadan hukum, serta kelebihan dan kekurangan dari status tersebut untuk perguruan tinggi negeri).
3. Menampilkan Forum berkomentar yang terhubung di setiap Universitas, guna untuk berdiskusi ataupun melihat komentar komentar yang di input oleh user dengan ketentuan login username dan password yang nantinya akan menampilkan username dari user tersebut.

# Penjelasan Prinsip OOP
1. Pada App.java terdapat  prinsip oop inheritance dimana App.java merupakan extends dari kelas Application yang merupakan bawaan dari javafx. 
2. Prinsip OOP yaitu Polimorfisme terjadi dalam penggunaan metode show() yang diimplementasikan dalam kelas PtSession, PtnButton, dan PtsButton. Meskipun semua kelas tersebut mengimplementasikan metode yang sama dari antarmuka SceneInterface, perilaku metode tersebut dapat berbeda sesuai dengan implementasi masing-masing kelas.
3. Prinsip OOP yaitu Encapsulation terlihat dalam penggunaan modifier private pada variabel primaryStage dan stage dalam kelas Home, PtSession, PtnButton, dan PtsButton. Hal ini memastikan bahwa akses langsung dari luar kelas terhadap variabel tersebut tidak dimungkinkan, sehingga keamanan dan kekonsistenan data terjaga.
4. Prinsip OOP yaitu Abstraksi terjadi ketika menggunakan interface SceneInterface. Dengan memisahkan antarmuka dari implementasinya,memungkinkan kelas lain untuk berinteraksi dengan objek tanpa perlu tahu detail implementasinya. Ini memungkinkan untuk fleksibilitas yang lebih besar dalam pengembangan dan pemeliharaan kode.

# Mentoring
1. Kak Muhammad Ardiansyah Asrifah - Senin, 13 Mei 2024
2. Kak Muhammad Ardiansyah Asrifah - Kamis, 23 Mei 2024 
3. Kak Muhammad Ardiansyah Asrifah - Senin, 26 Mei 2024
4. Kak Muhammad Ardiansyah Asrifah - Rabu, 28 Mei 2024

# Link Repository Github Project : 
https://github.com/AthifahNurRahmanMD/UINFO-App.git

# Screenshot
_Scene Masuk_
![scenemasuk](https://github.com/AthifahNurRahmanMD/UINFO-App/blob/9f1aa1ba390791cfe1ed480437961157db9bce6c/readme/scenemasuk.jpg)

_Scene Peguruan Tinggi_
![sceneperguruantinggi](https://github.com/AthifahNurRahmanMD/UINFO-App/blob/9f1aa1ba390791cfe1ed480437961157db9bce6c/readme/sceneperguruantinggi.jpg)

_Scene Perguruan Tinggi Negeri_
![sceneptn](https://github.com/AthifahNurRahmanMD/UINFO-App/blob/9f1aa1ba390791cfe1ed480437961157db9bce6c/readme/sceneptn.jpg)

_Scene Perguruan Tinggi Swasta_
![scenepts](https://github.com/AthifahNurRahmanMD/UINFO-App/blob/9f1aa1ba390791cfe1ed480437961157db9bce6c/readme/scenepts.jpg)

_Scene Detail Universitas_
![scenedetailuniv](https://github.com/AthifahNurRahmanMD/UINFO-App/blob/9f1aa1ba390791cfe1ed480437961157db9bce6c/readme/scenedetailuniv.jpg)

_Scene Jalur Pendaftaran_
![scenejalurpendaftaran](https://github.com/AthifahNurRahmanMD/UINFO-App/blob/9f1aa1ba390791cfe1ed480437961157db9bce6c/readme/scenejalurpendaftaran.jpg)

_Scene Jurusan/Fakultas_
![scenejurusanfakultas](https://github.com/AthifahNurRahmanMD/UINFO-App/blob/9f1aa1ba390791cfe1ed480437961157db9bce6c/readme/scenejurusanfakultas.jpg)

_Scene BKT_
![scenebkt](https://github.com/AthifahNurRahmanMD/UINFO-App/blob/9f1aa1ba390791cfe1ed480437961157db9bce6c/readme/scenebkt.jpg)

_Scene Forum_
![sceneforum](https://github.com/AthifahNurRahmanMD/UINFO-App/blob/9f1aa1ba390791cfe1ed480437961157db9bce6c/readme/sceneforum.jpg)

# Pengujian Aplikasi
![pengujianaplikasi](https://github.com/AthifahNurRahmanMD/UINFO-App/blob/9f1aa1ba390791cfe1ed480437961157db9bce6c/readme/pengujianaplikasi.png)
