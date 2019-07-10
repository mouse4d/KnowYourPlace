package com.knowyourplace.store

import com.knowyourplace.datamodels.Company
import java.util.*

class CompanyStore {

    fun companyWithName(name:String): Company? = if (companies.contains(name)) {
        Company(UUID.randomUUID(), name)
    } else {
        null
    }

    val companies = listOf("payworks", "holidu", "homealone")
}