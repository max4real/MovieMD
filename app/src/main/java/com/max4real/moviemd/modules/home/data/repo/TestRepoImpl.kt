package com.max4real.moviemd.modules.home.data.repo

import com.max4real.moviemd.modules.home.data.source.FakeMoviesTest
import com.max4real.moviemd.modules.home.domain.repo.TestRepo
import javax.inject.Inject


class TestRepoImpl @Inject constructor(
    val test: FakeMoviesTest
) : TestRepo {
    override suspend fun getTestData(): List<String> {
        return test.getTest()
    }
}