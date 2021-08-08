CREATE TABLE IF NOT EXISTS resume (
    id INT GENERATED BY DEFAULT AS IDENTITY,
    resume_name VARCHAR (255) NOT NULL ,
    work_experience VARCHAR (255) NOT NULL,
    education VARCHAR (255) NOT NULL,
    courses VARCHAR (255) NOT NULL,
    language VARCHAR (255) NOT NULL,
    abilities VARCHAR (255) NOT NULL,
    about_me VARCHAR (255) NOT NULL,
    PRIMARY KEY (id));