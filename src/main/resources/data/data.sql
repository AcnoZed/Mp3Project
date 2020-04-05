CREATE TABLE if NOT EXISTS Audio{
    id int auto_increment,
    artist varchar(255),
    year varchar(30),
    album varchar(255),
    title varchar(255),
    primary key(id),
};
delete from SONGS;