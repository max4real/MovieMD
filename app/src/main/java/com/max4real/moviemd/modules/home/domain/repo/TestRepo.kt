package com.max4real.moviemd.modules.home.domain.repo

interface TestRepo {
    suspend fun getTestData(): List<String>
}