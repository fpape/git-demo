package be.ebit.git.demo

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created with IntelliJ IDEA.
 * User: Frederic
 * Date: 7-5-12
 * Time: 22:18
 * To change this template use File | Settings | File Templates.
 */
class DefaultUserServiceTest extends Specification {
    def userService = new DefaultUserService()

    @Unroll
    def 'testing with invalid username'() {
        given:
        def password = 'super secret'
        when:
        userService.createUser(username, password)
        then:
        thrown(AssertionError)
        where:
        username << [null, '', ' ', '\t']
    }

    @Unroll
    def 'testing with invalid password'() {
        given:
        def username = 'testlogin'
        when:
        userService.createUser(username, null)
        then:
        thrown(AssertionError)
    }
}
