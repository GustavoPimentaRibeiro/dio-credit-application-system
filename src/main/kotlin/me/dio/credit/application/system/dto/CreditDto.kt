package me.dio.credit.application.system.dto

import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotNull
import me.dio.credit.application.system.entity.Credit
import me.dio.credit.application.system.entity.Customer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    @field:NotNull(message = "Invalid creditValue!") val creditValue: BigDecimal,
    @field:Future(message = "dayFirstInstallment must be in the future!") val dayFirstInstallment: LocalDate,
    @field:NotNull(message = "numberOfInstallments is not valid!") val numberOfInstallments: Int,
    @field:NotNull(message = "Invalid customerId") val customerId: Long
) {
    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstInstallment,
        numberOfInstallments = this.numberOfInstallments,
        customer = Customer(id = this.customerId)
    )
}
