
--INSERT INTO professor (id, title)
--VALUES (1, 'Dr. Sharma'),
  --     (2, 'Dr. Verma');

  --why i not use above query because it not allow us to generate id automatically
INSERT INTO professor (title) VALUES ('Dr. Sharma');
INSERT INTO professor (title) VALUES ('Dr. Verma');

INSERT INTO subject (title) VALUES ('Data Structures');
INSERT INTO subject (title) VALUES ('Operating Systems');
INSERT INTO subject (title) VALUES ('Database Systems');

INSERT INTO admission (fees) VALUES (50000);
INSERT INTO admission (fees) VALUES (52000);
INSERT INTO admission (fees) VALUES (51000);
INSERT INTO admission (fees) VALUES (53000);

INSERT INTO student (name, professor_id, subject_id, admission_id) VALUES ('Riya Gupta', 1, 2 , 2);
INSERT INTO student (name, professor_id, subject_id, admission_id) VALUES ('Aman Singh', 1, 1 , 1);
INSERT INTO student (name, professor_id, subject_id, admission_id) VALUES ('Kunal Yadav', 2, 1 , 3);
INSERT INTO student (name, professor_id, subject_id, admission_id) VALUES ('Sneha Jain', 2, 3 , 4);


