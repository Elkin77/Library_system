create database SystemLibrary;

use SystemLibrary;

create table Biblioteca
(
	id_biblioteca	int 			not null primary key auto_increment,
    nombre 			varchar(100)	not null,
    num_libros		int				not null
);

create table Usuario
(
	id_usuario			int not 		null 		primary key auto_increment,
    nombre				varchar(100)	not null,
    user				varchar(16)		not null	unique,
    password			varchar(16)		not null,
    nombre_comunidad	varchar(100)	not null,
    rol					varchar(25)		not null
);

create table Categoria
(
	id_categoria	int 			not null primary key auto_increment,
    nombre			varchar(100)	not null,
    descripcion		text(4000)		not null,
    codigo_registro	varchar(50)		not null unique
);

create table Tema
(
	id_tema			int 			not null primary key auto_increment,
    nombre			varchar(100)	not null,
    descripcion		text(4000)		not null,
    codigo_registro	varchar(50)		not null unique,
    id_categoria	int				not null,
    foreign key (id_categoria) references Categoria(id_categoria)
);

create table Libro
(
	id_libro		int 			not null primary key auto_increment,
    nombre			varchar(100)	not null,
    descripcion		text(4000)		not null,
    ubicacion		varchar(50)		not null,
    autor			varchar(50)		not null,
    foto			text(5000)		not null,
    id_biblioteca	int				not null,
    foreign key (id_biblioteca) references Biblioteca(id_biblioteca)
);

create table Prestamo
(
	id_prestamo		int 	not null primary key auto_increment,
    fecha_prestamo	date	not null,
    fecha_entrega	date	not null,
    id_usuario		int		not null,
    id_libro		int		not null,
    foreign key (id_usuario) references Usuario(id_usuario),
    foreign key (id_libro) references Libro(id_libro)
);

create table TemaLibro
(
	id_tema_libro	int not null primary key auto_increment,
    id_libro		int not null,
    id_tema			int not null,
    foreign key (id_libro)	references Libro(id_libro),
    foreign key (id_tema)	references Tema(id_tema)
);