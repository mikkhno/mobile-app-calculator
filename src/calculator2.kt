fun main() {
    // Задані вхідні параметри
    val carbon = 82.75    // Вуглець
    val hydrogen = 11.50  // Водень
    val oxygen = 1.20     // Кисень
    val sulfur = 2.80     // Сірка
    val lowerHeatingValue = 39.00 // Нижча теплота згоряння (Q_i) в МДж/кг
    val moisture = 3.00   // Вологість (W)
    val ashContent = 0.50 // Зольність (A)
    val vanadium = 250.0  // Вміст ванадію

    // Обчислення
    val totalMassFactor = (100 - moisture - ashContent) / 100

    val workingCarbon = carbon * totalMassFactor
    val workingHydrogen = hydrogen * totalMassFactor
    val workingOxygen = oxygen * (100 - 0.20 - 0.015) / 100
    val workingSulfur = sulfur * totalMassFactor
    val workingAsh = ashContent * (100 - moisture) / 100
    val workingVanadium = vanadium * (100 - moisture) / 100

    // Обчислення нижчої теплоти згоряння робочої маси
    val workingLowerHeatingValue = lowerHeatingValue * ((100 - moisture - ashContent) / 100) - 0.025*moisture

    // Вивід результатів
    println("Введені дані: C – $carbon%, H – $hydrogen%, O – $oxygen%, S – $sulfur%, V – $vanadium мг/кг, (Q_i) в МДж/кг – $lowerHeatingValue, W – $moisture%, A – $ashContent")
    println("\nСклад робочої маси мазуту:")
    println("Вуглець (C): %.2f%%".format(workingCarbon))
    println("Водень (H): %.2f%%".format(workingHydrogen))
    println("Кисень (O): %.2f%%".format(workingOxygen))
    println("Сірка (S): %.2f%%".format(workingSulfur))
    println("Зольність (A): %.2f%%".format(workingAsh))
    println("Ванадій (V): %.2f мг/кг".format(workingVanadium))
    println("Нижча теплота згоряння робочої маси (Q_ir): %.2f МДж/кг".format(workingLowerHeatingValue))
}
