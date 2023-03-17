package com.hephzibah.schedulerapp.viewmodel

import com.hephzibah.schedulerapp.data.model.Event
import com.hephzibah.schedulerapp.model.EventTest
import com.hephzibah.schedulerapp.ui.events.EventViewModel
import com.hephzibah.schedulerapp.utils.MainDispatcherRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class EventViewModelTest {

    private val viewModel = EventViewModel()

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()


    @Test
    fun `event list should be empty when no event has been added`() = runTest {
        val expected = viewModel.getEvents.value

        assertEquals(expected, listOf<Event>())
        assertNotEquals(expected, listOf(EventTest.firstEvent))
        assertEquals(expected.size, 0)
    }


    @Test
    fun `all event added to the list should be emitted`() = runTest {
        viewModel.addNewEvent(EventTest.firstEvent)
        viewModel.addNewEvent(EventTest.firstEvent)

        val expected = viewModel.getEvents.value

        assertEquals(expected, listOf(EventTest.firstEvent, EventTest.firstEvent))
    }

    @Test
    fun `event list should only contain added event`() = runTest {
        viewModel.addNewEvent(EventTest.firstEvent)

        val expected = viewModel.getEvents.value

        assertEquals(expected, listOf(EventTest.firstEvent))
        assertNotEquals(expected, listOf(EventTest.secondEvent))
        assertNotEquals(expected.size, 2)
    }

}