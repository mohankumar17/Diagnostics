INSERT INTO public.test(id, name, time, cost) 
VALUES(1, 'Covid RTPCR', '24 Hours', 1200);

INSERT INTO public.lab(id, name, rating, slots_available) 
VALUES(1, 'Los Altos Central Lab', 4 , 4);

INSERT INTO public.user(id, full_name, email)
VALUES
(1, 'Patrick Smith', 'patrick.smith@gmail.com'),
(2, 'Paul Brandon', 'paul.brandon@gmail.com');

INSERT INTO public.address(id, house_no, area, zipcode, city_state, user_id) 
VALUES(1, '2235 California Street  APT#021', 'Mountain View California', 114, 'Mountain View ,California', 1);

INSERT INTO public.patient(id, relation, name, dob, gender, user_id)
VALUES
(1, 'myself', 'Patrick', CAST('1990-06-25' AS DATE), 'male', 1),
(2, 'father', 'John', CAST('1970-10-07' AS DATE), 'male', 1),
(3, 'mother', 'Tina', CAST('1975-02-21' AS DATE), 'female', 1),
(4, 'myself', 'Paul', CAST('1995-05-18' AS DATE), 'male', 2);

INSERT INTO public.card(id, card_number, expiry_date, cvv, card_holder, user_id)
VALUES
(1, '1234 3456 4567 7895', '2025-07-21', '145', 'Patrick Smith', 1),
(2, '8994 3436 2566 0341', '2024-11-14', '732', 'Paul Brandon', 2);

INSERT INTO public.appointment(id, month, day, date, address_id, user_id, lab_id, test_id)
VALUES
(1, 'July', 'Saturday', 9, 1, 1, 1, 1);

INSERT INTO public.patient_appointment(patient_id, appointment_id)
VALUES
(1,1),
(2,1);
