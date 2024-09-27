DROP TABLE IF EXISTS movies;
DROP TABLE IF EXISTS directors;


create table directors (
                           id INT NOT NULL AUTO_INCREMENT,
                           directorid VARCHAR(36) NOT NULL UNIQUE,
                           name VARCHAR(255) NOT NULL,
                           dob DATE NOT NULL,
                           country VARCHAR(255) NOT NULL,
                           imageurl VARCHAR(255),
                           PRIMARY KEY (id)

);



create table movies (
                        id INT NOT NULL AUTO_INCREMENT,
                        movieId VARCHAR(36) NOT NULL UNIQUE,
                        title VARCHAR(255) NOT NULL,
                        releaseyear INT NOT NULL,
                        posterurl VARCHAR(255),
                        directorid VARCHAR(36) NOT NULL,
                        PRIMARY KEY (id),
                        FOREIGN KEY (directorid) references directors(directorid)
);