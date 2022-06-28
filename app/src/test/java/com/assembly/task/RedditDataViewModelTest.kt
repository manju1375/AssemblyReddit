package com.assembly.task

import android.content.Context
import com.assembly.task.api.RedditApiServices
import com.assembly.task.api.network.Resource
import com.assembly.task.repository.RedditDetailsRepository
import com.assembly.task.ui.main.viewmodel.RedditDataViewModel
import com.assemblytask.models.PicsModel
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.powermock.api.mockito.PowerMockito


class RedditDataViewModelTest {
    private lateinit var viewModel: RedditDataViewModel
    private var picsModel = PicsModel(null,null)
    @ExperimentalCoroutinesApi
    private val testDispatcher = TestCoroutineDispatcher()
    private var context: Context? = null
    lateinit var repo: RedditDetailsRepository
    private var gson:Gson? = null
    private lateinit var jsonString: String
    lateinit var redditApiServices: RedditApiServices

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        repo = PowerMockito.mock(RedditDetailsRepository::class.java)
        context = Mockito.mock(Context::class.java)
        gson = Mockito.mock(Gson::class.java)
        redditApiServices = Mockito.mock(RedditApiServices::class.java)
        viewModel = RedditDataViewModel(repo)
        PowerMockito.whenNew(Gson::class.java).withAnyArguments().thenReturn(gson)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun testNasaDetails() {
        CoroutineScope(testDispatcher).launch {
            Mockito.`when`(repo.getPics("gaming")).thenReturn(Resource.Success(picsModel))
            assertEquals(viewModel.getPics("gaming"), picsModel)
        }
    }
}