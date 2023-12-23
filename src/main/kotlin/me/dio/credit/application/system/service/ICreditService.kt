package me.dio.credit.application.system.service

import me.dio.credit.application.system.entity.Credit
import java.util.UUID

interface ICreditService {
    fun save(credit: Credit): Credit
    fun findAllByCostumer(costumerId: Long): List<Credit>
    fun findByCreditCode(customerId: Long, creditCode: UUID): Credit?
}