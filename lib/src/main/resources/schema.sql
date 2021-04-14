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