create database movies;
use movies;

CREATE TABLE users (
    users_num INT AUTO_INCREMENT PRIMARY KEY,
    id VARCHAR(10) UNIQUE,
    phone_number VARCHAR(13),
    address VARCHAR(20),
    password VARCHAR(100),
    username VARCHAR(10)
);
CREATE TABLE movie_list (
    movie_num INT AUTO_INCREMENT PRIMARY KEY,
    movie_name VARCHAR(20),
    price INT,
    relese_date DATE,
    finish_date DATE,
    movie_showtime INT,
    movie_code VARCHAR(20) UNIQUE,
    movie_pictrue BLOB
);

CREATE TABLE theaters (
    theaters_num INT PRIMARY KEY,
    total_seats INT
);

CREATE TABLE showtimes (
    showtime_num INT PRIMARY KEY,
    theaters_num INT,
    movie_num INT,
    startmovie_datetime DATETIME,
    FOREIGN KEY (theaters_num) REFERENCES theaters(theaters_num),
    FOREIGN KEY (movie_num) REFERENCES movie_list(movie_num)
);

CREATE TABLE seats (
    seats_num INT PRIMARY KEY,
    theaters_num INT,
    reservation_info BOOL,
    FOREIGN KEY (theaters_num) REFERENCES theaters(theaters_num)
);

CREATE TABLE reservations (
    num INT AUTO_INCREMENT PRIMARY KEY,
    users_num INT,
    showtime_num INT,
    FOREIGN KEY (users_num) REFERENCES users(users_num),
    FOREIGN KEY (showtime_num) REFERENCES showtimes(showtime_num)
);

#영화내역 
INSERT INTO movies.movie_list
(`movie_name`,
`price`,
`relese_date`,
`finish_date`,
`movie_showtime`,
`movie_code`,
`movie_pictrue`,
`movie_details`)
VALUES
('괴물', 9000, '2024-04-01', '2024-04-30', 143, 'A001', 'images/monster.jpg', '아버지(변희봉)가 운영하는 한강매점, 늘어지게 낮잠 자던 강두(송강호)는 우연히 특이한 광경을 목격하게 된다. 생전 보도 못 한 무언가가 한강다리에 매달려 움직이는 것이다. 정체를 알 수 없는 괴물은 둔치 위로 올라와 사람들을 거침없이 깔아뭉개고, 무차별로 물어뜯기 시작한다. 순식간에 아수라장으로 돌변하는 한강변. 강두도 뒤늦게 딸 현서(고아성)를 데리고 정신없이 도망가지만, 꼭 잡았던 현서의 손을 놓치고 만다. 하루아침에 집과 생계, 그리고 현서까지 모든 것을 잃게 된 강두 가족. 돈도 없고 빽도 없는 그들은 위험 구역으로 선포된 한강 어딘가에 있을 현서를 찾아 나선다.');
