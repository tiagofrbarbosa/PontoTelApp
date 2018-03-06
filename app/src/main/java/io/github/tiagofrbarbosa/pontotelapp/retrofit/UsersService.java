package io.github.tiagofrbarbosa.pontotelapp.retrofit;

import io.github.tiagofrbarbosa.pontotelapp.model.UserList;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by tfbarbosa on 05/03/18.
 */

public interface UsersService {

    @GET("data.json")
    Call<UserList> getUsers();
}
