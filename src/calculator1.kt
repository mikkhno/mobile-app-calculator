class FuelCalculator {

    fun calculateDryMass(wp: Double): Double {
        return 100/(100 - wp)
    }

    fun calculateCombustibleMass(wp: Double, ap: Double): Double {
        return 100/(100 - wp - ap)
    }

    fun calculateLowerHeatingValue(hp: Double, cp: Double, sp: Double, op: Double, wp: Double): Double {
        return 339 * cp + 1030 * hp - 108.8 * op + 108.8 * sp - 25 * wp
    }


    fun calculateForFuel(hp: Double, cp: Double, sp: Double, np: Double, op: Double, wp: Double, ap: Double) {
        val dryMass = calculateDryMass(wp)
        val combustibleMass = calculateCombustibleMass(wp, ap)
        val lowerHeatingValue = calculateLowerHeatingValue(hp, cp, sp, op, wp)
        val lowerHeatingValueDryMass = lowerHeatingValue * dryMass
        val lowerHeatingValueCombustibleMass = lowerHeatingValue * combustibleMass


        println("Hp – $hp%, C – $cp%, Sp – $sp%, Np – $np%, Op – $op%, Wp – $wp%, Ap – $ap%")
        println("Коефіцієнт переходу від робочої до сухої маси становить: %.2f".format(dryMass))
        println("Коефіцієнт переходу від робочої до горючої маси становить: %.2f".format(combustibleMass))
        println("Нижча теплота згоряння для робочої маси за заданим складом компонентів палива\n" +
                "становить: Дж/кг %.2f".format(lowerHeatingValue))
        println("Нижча теплота згоряння для сухої маси за заданим складом компонентів палива\n" +
                "становить: Дж/кг %.2f".format(lowerHeatingValueDryMass))
        println("Нижча теплота згоряння для горючої маси за заданим складом компонентів палива\n" +
                "становить: Дж/кг %.2f".format(lowerHeatingValueCombustibleMass))
    }
}

fun main() {
    FuelCalculator().calculateForFuel(3.4, 70.6, 2.7,1.2,1.9, 5.0, 15.2)
}

