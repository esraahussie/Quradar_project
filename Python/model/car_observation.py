class CarObservation:
    def __init__(self, plate_number, date, car_type, speed, seatbelt_fastened):
        self.plate_number = plate_number
        self.date = date
        self.car_type = car_type
        self.speed = speed
        self.seatbelt_fastened = seatbelt_fastened

    def get_plate_number(self):
        return self.plate_number

    def get_date(self):
        return self.date

    def get_car_type(self):
        return self.car_type

    def get_speed(self):
        return self.speed

    def is_seatbelt_fastened(self):
        return self.seatbelt_fastened