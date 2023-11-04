INSERT INTO tb_person (first_name, last_name, person_bio, address, gender) VALUES ('Ezequiel', 'Everton', 'Gosto de Cafe', 'R. Paraguai', 'Male');



INSERT INTO tb_cargo(cargo_name) VALUES ('PROFESSOR');
INSERT INTO tb_cargo(cargo_name) VALUES ('ALUNO');
INSERT INTO tb_cargo(cargo_name) VALUES ('PROGRAMADOR');

INSERT INTO person_cargo(person_id, cargo_id) VALUES (1, 1);
INSERT INTO person_cargo(person_id, cargo_id) VALUES (1, 2);

