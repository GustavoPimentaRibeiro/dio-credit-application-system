package me.dio.credit.application.system.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.credit.application.system.entity.Address
import me.dio.credit.application.system.entity.Customer
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDto(
    @field:NotEmpty(message = "fistName cannot be empty!")
    val firstName: String,

    @field:NotEmpty(message = "lastName cannot be empty!")
    val lastName: String,

    @field:NotEmpty(message = "CPF cannot be empty!")
    @field:CPF(message = "Invalid CPF!")
    val cpf: String,

    @field:NotNull(message = "income invalid input!")
    val income: BigDecimal,

    @field:NotEmpty(message = "Email cannot be empty!")
    @field:Email(message = "Invalid email!")
    val email: String,

    @field:NotEmpty(message = "password cannot be empty!")
    val password: String,

    @field:NotEmpty(message = "zipCode cannot be empty!")
    val zipCode: String,

    @field:NotEmpty(message = "street cannot be empty!")
    val street: String
) {
    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        password = this.password,
        address = Address(
            zipCode = this.zipCode,
            street = this.street
        )
    )
}
