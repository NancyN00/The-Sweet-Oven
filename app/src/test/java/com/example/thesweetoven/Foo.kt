package com.example.thesweetoven

import org.junit.Before
import org.junit.Test

class FooTest {

    private lateinit var foo: Foo

    @Before
    fun setup() {
        foo = Foo(2)
    }

    @Test
    fun `testthis return true if num == 2`() {
        assert(foo.testThis())
    }

    @Test
    fun `testthis returns false if num != true`() {
        foo = Foo(3)
        assert(!foo.testThis())
    }

}