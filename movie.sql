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

