package light.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

public class ViewHolder {
     private SparseArray<View> views;
     private int position;
     private View convertView;

     public ViewHolder(Context context, ViewGroup parent,int layoutid,int position){
         this.position=position;
         views=new SparseArray<>();
         this.convertView= LayoutInflater.from(context).inflate(layoutid,parent,false);
         convertView.setTag(this);

     }
     public static ViewHolder getViewHolder(Context context,View convertView,ViewGroup parent,int layoutid, int position){
          if (convertView==null){
               return new ViewHolder(context,parent,layoutid,position);
          }else{
               ViewHolder viewHolder= (ViewHolder) convertView.getTag();
               viewHolder.position=position;
               return viewHolder;
          }
     }
     public <T extends View>T getView(int id){
          View view= views.get(id);
          if (view==null){
               view=convertView.findViewById(id);
               views.append(id,view);
          }
          return (T)view;
     }
     public View getConvertView(){
          return convertView;
     }
     public ViewHolder setText(int id,String str){
          View view = views.get(id);
          if (view instanceof TextView){
               ((TextView)view).setText(str);
          }else{
               throw new  ClassCastException(view.getClass().getName()+"can not cast to TextView");
          }
          return  this;
     }
     public ViewHolder setCheckBoxText(int id,String str){
          View view = views.get(id);
          if (view instanceof CheckBox){
               ((CheckBox)view).setText(str);
          }else{
               throw new  ClassCastException(view.getClass().getName()+"can not cast to CheckBox");
          }
          return  this;
     }

}
