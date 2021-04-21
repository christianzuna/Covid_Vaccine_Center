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

INSERT INTO employees (fname, lname, age, email, pass) VALUES ('admin', 'admin', 0, 'admin@admin', 'admin');
INSERT INTO employees (fname, lname, age, email, pass) VALUES ('employee', 'employee', 12, 'employee@admin', 'admin');
INSERT INTO patients (fname, lname, age, email, pass) VALUES ('patient', 'patient', 0, 'patient@patient', 'patient');