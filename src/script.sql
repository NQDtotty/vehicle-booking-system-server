CREATE TABLE public.users (
	user_id text NOT NULL PRIMARY KEY,
    password text NOT NULL,
    fullname text NOT NULL,
    gender text NOT NULL,
    phone_number text NOT NULL,
    email text NOT NULL,
    role text NOT NULL,
    status text NOT NULL
);
CREATE TABLE public.routes (
	route_id text NOT NULL PRIMARY KEY,
    "from" text NOT NULL,
    arrive text NOT NULL,
    distance text NOT NULL,
    image text,
	fare text NOT NULL,
    status text NOT NULL
);
CREATE TABLE public.feedbacks (
	feedback_id text NOT NULL PRIMARY KEY,
    user_id text NOT NULL,
    message text NOT NULL,
    response text NOT NULL,
    status text NOT NULL,
	CONSTRAINT fk_user
      FOREIGN KEY(user_id)
	  	REFERENCES users(user_id)
);
CREATE TABLE public.vehicles (
	vehicle_id text NOT NULL PRIMARY KEY,
    license_plate text NOT NULL,
    color text NOT NULL,
    seat int NOT NULL,
    vehicle_type text NOT NULL,
	status text NOT NULL
);
CREATE TABLE public.stations (
	station_id text NOT NULL PRIMARY KEY,
    station_start text NOT NULL,
    station_end text NOT NULL,
    status text NOT NULL
);
CREATE TABLE public.trips (
	trip_id text NOT NULL PRIMARY KEY,
    vehicle_id text NOT NULL,
    "date" date NOT NULL,
    "time" text NOT NULL,
    route_id text NOT NULL,
	station_id text NOT NULL,
    status text NOT NULL,
	CONSTRAINT fk_vehicle
      FOREIGN KEY(vehicle_id)
	  	REFERENCES vehicles(vehicle_id),
	CONSTRAINT fk_route
      FOREIGN KEY(route_id)
	  	REFERENCES routes(route_id),
	CONSTRAINT fk_station
      FOREIGN KEY(station_id)
	  	REFERENCES stations(station_id)
);
CREATE TABLE public.tickets (
	ticket_id text NOT NULL PRIMARY KEY,
    booking_date date NOT NULL,
    seat_number int NOT NULL,
    price int NOT NULL,
    user_id text NOT NULL,
	trip_id text NOT NULL,
	status text NOT NULL,
	CONSTRAINT fk_user
      FOREIGN KEY(user_id)
	  	REFERENCES users(user_id),
	CONSTRAINT fk_trip
      FOREIGN KEY(trip_id)
	  	REFERENCES trips(trip_id)
);

