package io.github.tiagofrbarbosa.pontotelapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import io.github.tiagofrbarbosa.pontotelapp.R;
import io.github.tiagofrbarbosa.pontotelapp.model.User;

/**
 * Created by tfbarbosa on 05/03/18.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.mViewHolder> {

    private List<User> listUsers;

    public UserAdapter(List<User> listUsers) {
        this.listUsers = listUsers;
    }

    @Override
    public mViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemUser = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.holder_user, parent, false);

        return new mViewHolder(itemUser);
    }

    @Override
    public void onBindViewHolder(mViewHolder holder, int position) {

        User user = listUsers.get(position);
        holder.textViewId.setText(user.getId());
        holder.textViewName.setText(user.getName());
        holder.textViewPwd.setText(user.getPwd());
    }

    @Override
    public int getItemCount() {
        return listUsers.size();
    }


    public class mViewHolder extends RecyclerView.ViewHolder{

        TextView textViewId, textViewName, textViewPwd;

        public mViewHolder(View itemView) {
            super(itemView);

            textViewId = itemView.findViewById(R.id.tv_id);
            textViewName = itemView.findViewById(R.id.tv_name);
            textViewPwd = itemView.findViewById(R.id.tv_pwd);
        }
    }
}
