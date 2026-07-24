class Violation:
    def __init__(self, description, fee):
        self.description = description
        self.fee = fee

    def get_description(self):
        return self.description

    def get_fee(self):
        return self.fee