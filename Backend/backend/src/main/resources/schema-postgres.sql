DROP SCHEMA public CASCADE;
CREATE SCHEMA public;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO public;
GRANT ALL ON SCHEMA public TO bc41;

CREATE TABLE "user" (
  "id" serial PRIMARY KEY,
  "full_name" VARCHAR(50),
  "email" VARCHAR(50)
);

CREATE TABLE "address" (
  "id" serial PRIMARY KEY ,
  "house_no" VARCHAR (255),
  "area" varchar(255),
  "zipcode" INT,
  "city_state" VARCHAR (255),
  "user_id" INT DEFAULT 1,
   CONSTRAINT "FK.address.users"
   FOREIGN KEY("user_id") 
      REFERENCES "user"("id")
);

CREATE TABLE "test" (
  "id" serial PRIMARY KEY,
  "name" VARCHAR(50),
  "time" VARCHAR(50),
  "cost" INT
);

CREATE TABLE "lab" (
  "id" serial PRIMARY KEY,
  "name" VARCHAR(50),
  "rating" NUMERIC (2,1),
  "slots_available" INT
);

CREATE TABLE "patient" (
  "id" serial PRIMARY KEY,
  "relation" VARCHAR(10),
  "name" VARCHAR(255),
  "dob" DATE,
  "gender" VARCHAR(10),
  "user_id" INT DEFAULT 1,
  CONSTRAINT "FK.patient.users"
   FOREIGN KEY("user_id") 
      REFERENCES "user"("id")
);

CREATE TABLE "card" (
  "id" serial PRIMARY KEY,
  "card_number" VARCHAR(25),
  "expiry_date" VARCHAR(10),
  "cvv" VARCHAR(3),
  "card_holder" VARCHAR(50),
  "user_id" INT DEFAULT 1,
   CONSTRAINT "FK.card.users"
   FOREIGN KEY("user_id") 
      REFERENCES "user"("id")
);

CREATE TABLE "appointment" (
  "id" serial PRIMARY KEY,
  "month" VARCHAR(10),
  "day" VARCHAR(10),
  "date" INT,
   "address_id" INT,
  "user_id" INT DEFAULT 1,
  "lab_id" INT,
  "test_id" INT,
  CONSTRAINT "FK_appointment.address"
    FOREIGN KEY ("address_id")
      REFERENCES "address"("id"),
  CONSTRAINT "FK_appointment.users"
    FOREIGN KEY ("user_id")
      REFERENCES "user"("id"),
  CONSTRAINT "FK_appointment.labs"
    FOREIGN KEY ("lab_id")
      REFERENCES "lab"("id"),
  CONSTRAINT "FK_appointment.tests"
    FOREIGN KEY ("test_id")
      REFERENCES "test"("id")
);

CREATE TABLE "patient_appointment" (
  "patient_id" INT,
  "appointment_id" INT,
  CONSTRAINT "FK.patient_appointment.patients"
  FOREIGN KEY ("patient_id")
      REFERENCES "patient"("id"),
  CONSTRAINT "FK.patient_appointment.appointments" 
  FOREIGN KEY ("appointment_id")
      REFERENCES "appointment"("id")
);

CREATE TABLE "test_lab" (
  "test_id" INT,
  "lab_id" INT,
  CONSTRAINT "FK_test_lab.test_id"
    FOREIGN KEY ("test_id")
      REFERENCES "test"("id"),
  CONSTRAINT "FK_test_lab.labs"
    FOREIGN KEY ("lab_id")
      REFERENCES "lab"("id")
);