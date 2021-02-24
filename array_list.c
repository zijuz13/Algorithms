#include "array_list.h"
ArrayList* alist_initialize(int maxSize, int typeSize, char* name){
  ArrayList* list= (ArrayList*) malloc(sizeof(ArrayList));
  list->maxSize=maxSize;
  list->size=0;
  list->type=name;
  list->itemSize=typeSize;
  list->arr=calloc(maxSize,sizeof(void*));
  return list;
}
bool alist_add(ArrayList* list, void* elem){

}
bool alist_add_at(ArrayList*, int, void*){

}
bool checkIndex(int index,int size){
 if(index<0||index>=size){
     return false;
 }else{
     return true;
 }
}
void alist_clear(ArrayList* list){

}
void* alist_get(ArrayList* list, int index){
    if(!checkIndex(index,list->size)){
        return NULL;
    }
    return list->arr[index];
}
int alist_index_of(ArrayList* list, void* elem){
    
}
void* alist_remove(ArrayList* list, int index){

}
bool alist_destroy(ArrayList* list){
if(NULL!=list->arr){
    for(int i=0;i<list->size;++i){
       free(list->arr[i]);
       list->arr[i]=NULL; 
    }
    free(list->arr);
    list->arr=NULL;
}
free(list);
list=NULL;
return true;
}
bool alist_resize(ArrayList* list){
    if(NULL==list){
        return false;
    }    
 list->maxSize*=2;
 list->arr=recalloc(list->arr,list->maxSize*2);
 return true;   
}



int main(){
    return 0;
}
