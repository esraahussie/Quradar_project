class Fine:
    def __init__(self, plate_number, violations):
        self.plate_number = plate_number
        self.violations = violations

    def get_plate_number(self):
        return self.plate_number

    def get_violations(self):
        return self.violations

    def get_total_amount(self):
        total = 0
        for i in range(len(self.violations)):
            v = self.violations[i]
            total += v.get_fee()
        return total

    def __str__(self):
        text = "Traffic for car " + self.plate_number + "\n"
        text += "Total amount: " + str(int(self.get_total_amount())) + " EGP\n"
        text += "Violations:"
        for i in range(len(self.violations)):
            v = self.violations[i]
            text += "\n- " + v.get_description() + " : " + str(int(v.get_fee())) + " EGP"
        return text