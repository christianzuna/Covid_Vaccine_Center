CREATE TABLE patients (
    pat_id serial primary key, 
    fname text not null, 
    lname text not null, 
    age integer not null,
    email text unique,
    pass text not null
); 

CREATE TABLE employees (
    emp_id serial primary key, 
    fname text not null, 
    lname text not null, 
    age integer not null,
    email text unique,
    pass text not null
);

CREATE TABLE appointment (
    appt_id serial primary key, 
    patient_id integer not null references patients (pat_id),
    employee_id integer not null references employees(emp_id)
);

INSERT INTO employees (fname, lname, age, email, pass) VALUES ('employee', 'employee', 12, 'employee@employee', 'employee');
INSERT INTO employees (fname, lname, age, email, pass) VALUES ('admin', 'admin', 50, 'admin@employee', 'employee');
INSERT INTO employees (fname, lname, age, email, pass) VALUES ('rodolfo', 'largo', 22, 'rod@employee', 'rod');
INSERT INTO employees (fname, lname, age, email, pass) VALUES ('juan', 'mendes', 22, 'juan@employee', 'juan');
INSERT INTO employees (fname, lname, age, email, pass) VALUES ('bob', 'simpson', 22, 'bob@employee', 'bob');
INSERT INTO employees (fname, lname, age, email, pass) VALUES ('tom', 'parker', 22, 'tom@employee', 'tom');

INSERT INTO patients (fname, lname, age, email, pass) VALUES ('patient', 'patient', 0, 'patient@patient', 'patient');
INSERT INTO patients (fname, lname, age, email, pass) VALUES ('elmo', 'elmo', 20, 'elmo@patient', 'elmo');
INSERT INTO patients (fname, lname, age, email, pass) VALUES ('daniel', 'smith', 20, 'daniel@patient', 'daniel');
INSERT INTO patients (fname, lname, age, email, pass) VALUES ('Justin', 'Beiber', 30, 'justin@patient', 'justin');
INSERT INTO patients (fname, lname, age, email, pass) VALUES ('fred', 'barker', 30, 'fred@patient', 'fred');
INSERT INTO patients (fname, lname, age, email, pass) VALUES ('frank', 'brayant', 30, 'frank@patient', 'frank');

INSERT INTO appointment (patient_id, employee_id) VALUES (1,1);
INSERT INTO appointment (patient_id, employee_id) VALUES (1,2);
INSERT INTO appointment (patient_id, employee_id) VALUES (1,3);
INSERT INTO appointment (patient_id, employee_id) VALUES (2,1);
INSERT INTO appointment (patient_id, employee_id) VALUES (2,2);
INSERT INTO appointment (patient_id, employee_id) VALUES (2,3);
INSERT INTO appointment (patient_id, employee_id) VALUES (3,1);
INSERT INTO appointment (patient_id, employee_id) VALUES (3,2);
INSERT INTO appointment (patient_id, employee_id) VALUES (3,3);



-- SELECT fname, lname, age, email, pass FROM patients INNER JOIN appointment on appointment.patient_id=patients.pat_id WHERE patients.pat_id=1 OR appointment.employee_id=3;

-- -- this lets me see all info patient from appointment table--
-- SELECT fname, lname, age, email FROM patients INNER JOIN appointment on appointment.patient_id=patients.pat_id;
-- -- this lets me see all info employee from appointment table--
-- SELECT fname, lname, age, email FROM employees INNER JOIN appointment on appointment.employee_id=employees.emp_id;

-- -- this lets me see the app id assigned to each employee--
-- SELECT appointment.appt_id, employees.fname, employees.lname, employees.age, employees.email FROM employees INNER JOIN appointment on appointment.employee_id=employees.emp_id;

-- -- this lets me see the patient info per appointment id 
-- SELECT appointment.appt_id, patients.fname, patients.lname, patients.age, patients.email FROM patients INNER JOIN appointment on appointment.patient_id=patients.pat_id;

-- --this lets me see the app_id's associated to a patient email(username)--
-- SELECT appointment.appt_id, patients.fname, patients.lname, patients.age, patients.email FROM patients INNER JOIN appointment on appointment.patient_id=employees.pat_id where patients.email='elmo@patient';

-- SELECT appointment.appt_id, employees.fname, employees.lname, employees.age, employees.email FROM employees INNER JOIN appointment on appointment.employee_id=employees.emp_id WHERE employees.email='patient@patient';
