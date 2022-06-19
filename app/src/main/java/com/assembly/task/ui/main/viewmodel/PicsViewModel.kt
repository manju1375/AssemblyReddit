package com.assembly.task.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assembly.task.api.network.Resource
import com.assembly.task.repository.PicsRepository
import com.assemblytask.models.PicsModel
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Developed by Manjunath on 19,June,2022
 */

@HiltViewModel
@Module
@InstallIn(FragmentComponent::class,ActivityComponent::class)
class PicsViewModel @Inject constructor(private val picsRepository: PicsRepository) : ViewModel() {

    private val _picsModelResponse: MutableLiveData<Resource<PicsModel>> = MutableLiveData()

    val picsModelResponse: LiveData<Resource<PicsModel>>
        get() = _picsModelResponse

    fun getPics() = viewModelScope.launch {
        _picsModelResponse.value = picsRepository.getPics()
    }

}