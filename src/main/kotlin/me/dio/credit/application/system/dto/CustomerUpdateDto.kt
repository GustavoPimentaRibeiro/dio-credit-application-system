package me.dio.credit.application.system.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.credit.application.system.entity.Customer
import java.math.BigDecimal

data class CustomerUpdateDto(
    @field:NotEmpty(message = "firstName cannot be empty!") val firstName: String,
    @field:NotEmpty(message = "lastName cannot be empty!") val lastName: String,
    @field:NotNull(message = "income invalid input!") val income: BigDecimal,
    @field:NotEmpty(message = "zipCode cannot be empty!") val zipCode: String,
    @field:NotEmpty(message = "street cannot be empty!") val street: String
) {
    fun toEntity(customer: Customer): Customer {
        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.income = this.income
        customer.address.street = this.street
        customer.address.zipCode = this.zipCode
        return customer
    }
}
