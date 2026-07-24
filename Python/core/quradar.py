from model.fine import Fine

class QuRadar:
    def __init__(self, rules):
        self.rules = list(rules)
        self.issued_fines = []

    def process_observation(self, observation):
        violations = []
        for i in range(len(self.rules)):
            rule = self.rules[i]
            result = rule.evaluate(observation)
            if result is not None:
                violations.append(result)

        if len(violations) == 0:
            return None

        fine = Fine(observation.get_plate_number(), violations)
        self.issued_fines.append(fine)
        return fine

    def get_all_possible_fines(self):
        totals_by_plate = {}
        for i in range(len(self.issued_fines)):
            fine = self.issued_fines[i]
            plate = fine.get_plate_number()
            amount = fine.get_total_amount()
            if plate in totals_by_plate:
                totals_by_plate[plate] = totals_by_plate[plate] + amount
            else:
                totals_by_plate[plate] = amount
        return totals_by_plate

    def get_all_violated_rules(self):
        counts = {}
        for i in range(len(self.issued_fines)):
            fine = self.issued_fines[i]
            violations = fine.get_violations()
            for j in range(len(violations)):
                description = violations[j].get_description()
                if description in counts:
                    counts[description] = counts[description] + 1
                else:
                    counts[description] = 1
        return counts