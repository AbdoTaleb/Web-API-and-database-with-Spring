-- DELETE FROM tb_movie;
-- DELETE FROM tb_franchise;
-- DELETE FROM tb_character;


INSERT INTO tb_movie(movie_title, movie_genre, movie_release_date, movie_director, movie_poster_url, movie_trailer)
VALUES ('Captain America: Civil War', 'Action',
        2016, 'Anthony Russo',
        'https://m.media-amazon.com/images/M/MV5BMjQ0MTgyNjAxMV5BMl5BanBnXkFtZTgwNjUzMDkyODE@._V1_SX300.jpg',
        'https://www.youtube.com/watch?v=dKrVegVI0Us');



INSERT INTO tb_movie(movie_title, movie_genre, movie_release_date, movie_director, movie_poster_url, movie_trailer)
VALUES ('Doctor Strange', 'Fantasy',
        2016, 'Scott Derrickson',
        'https://m.media-amazon.com/images/M/MV5BNjgwNzAzNjk1Nl5BMl5BanBnXkFtZTgwMzQ2NjI1OTE@._V1_SX300.jpg',
        'https://www.youtube.com/watch?v=HSzx-zryEgM');

INSERT INTO tb_movie(movie_title, movie_genre, movie_release_date, movie_director, movie_poster_url, movie_trailer)
VALUES ('Doctor Strange Test', 'Fantasy',
        2016, 'Scott Derrickson',
        'https://m.media-amazon.com/images/M/MV5BNjgwNzAzNjk1Nl5BMl5BanBnXkFtZTgwMzQ2NjI1OTE@._V1_SX300.jpg',
        'https://www.youtube.com/watch?v=HSzx-zryEgM');


INSERT INTO tb_movie(movie_title, movie_genre, movie_release_date, movie_director, movie_poster_url, movie_trailer)
VALUES ('Luca', 'Comedy',
        2021, 'Enrico Casarosa',
        'https://m.media-amazon.com/images/M/MV5BZTQyNTU0MDktYTFkYi00ZjNhLWE2ODctMzBkM2U1ZTk3YTMzXkEyXkFqcGdeQXVyNTI4MzE4MDU@._V1_SX300.jpg',
        'https://www.youtube.com/watch?v=0hgHY9k-44U');


INSERT INTO tb_franchise(franchise_name, franchise_description)
VALUES ('Marvel Cinematic Universe', 'The Marvel Cinematic Universe (MCU) films are a series of American superhero' ||
                                     ' films produced by Marvel Studios based on characters that appear in publications by Marvel Comics');


INSERT INTO tb_franchise(franchise_name, franchise_description)
VALUES ('Walt Disney Pictures', 'Walt Disney Pictures[3] is an American film production company and subsidiary of Walt Disney Studios, ' ||
                                'a division of Disney Entertainment, which is owned by The Walt Disney Company.');



INSERT INTO tb_character(character_name, character_alias, character_gender, character_picture_url)
VALUES ('Chris Evans', 'Some alias', 'male',
        'https://upload.wikimedia.org/wikipedia/commons/3/33/Mark_Kassen%2C_Tony_C%C3%A1rdenas_and_Chris_Evans_%28cropped%29.jpg');


INSERT INTO tb_character(character_name, character_alias, character_gender, character_picture_url)
VALUES ('Robert Downey Jr', 'Some alias', 'male',
        'https://www.onthisday.com/images/people/robert-downey-jr-medium.jpg');