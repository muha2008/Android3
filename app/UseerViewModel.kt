class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val sharedPreferences: SharedPreferences = application.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> get() = _user

    init {
        loadUser()
    }

    fun saveUser(user: User) {
        _user.value = user
        with(sharedPreferences.edit()) {
            putString("username", user.username)
            putInt("age", user.age)
            putString("email", user.email)
            putString("password", user.password)
            apply()
        }
    }

    private fun loadUser() {
        val username = sharedPreferences.getString("username", null)
        val age = sharedPreferences.getInt("age", -1)
        val email = sharedPreferences.getString("email", null)
        val password = sharedPreferences.getString("password", null)

        if (username != null && age != -1 && email != null && password != null) {
            _user.value = User(username, age, email, password)
        }
    }
}
