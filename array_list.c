#include "array_list.h"
ArrayList* alist_initialize(int maxSize, int typeSize, char* name){
  ArrayList* list= (ArrayList*) malloc(sizeof(ArrayList));
  list->maxSize=maxSize;
  list->size=0;
  list->type=name;
  list->itemSize=typeSize;
  //allocate continuous memory blocks for the 2-D pointer to point
  list->arr=calloc(maxSize,sizeof(void*));
  return list;
}
bool alist_add(ArrayList* list, void* elem){
 if(elem==NULL||list==NULL){
     return false;
 }
  return alist_add_at(list,list->size,elem);
}
bool alist_add_at(ArrayList* list, int index,void* element){
    int size=list->size;
    //the specified index should be in the range of [0,size]
if(index<0||index>size){
    return false;
}
//if the new size is greater than the maxSize, the list should grow
int maxSize=list->maxSize;
if(size+1>maxSize){
    alist_resize(list);
}
if(0<=index&&index<size){
    void** temp=calloc(list->maxSize,sizeof(void*));
    void** originalArr=list->arr;
    for(int i=0;i<index;++i){
        temp[i]=malloc(list->itemSize);
        memcpy(temp[i],originalArr[i],list->itemSize);
        free(originalArr[i]);
    }
    temp[index]=malloc(list->itemSize);
    memcpy(temp[index],element,list->itemSize);
    for(int j=index+1,i=index;i<size;++i){
        temp[j]=malloc(list->itemSize);
        memcpy(temp[j++],originalArr[i],list->itemSize);
        free(originalArr[i]);
    }
    free(originalArr);
    originalArr=NULL;
    list->arr=temp;
    temp=NULL;
}else{
    list->arr[size]=malloc(list->itemSize);
memcpy(list->arr[size],element,list->itemSize);
}
list->size++;
return true;
}
bool checkIndex(int index,int size){
 if(index<0||index>=size){
     return false;
 }else{
     return true;
 }
}
void alist_clear(ArrayList* list){
   int size=list->size;
   list->size=0;
   for(int i=0;i<size;++i){
       free(list->arr[i]);
       list->arr[i]=NULL;
   }
}
void* alist_get(ArrayList* list, int index){
    if(!checkIndex(index,list->size)){
        return NULL;
    }
    return list->arr[index];
}
int alist_index_of(ArrayList* list, void* elem){
    int size=list->size;
    for(int i=0;i<size;i++){
     if(0==memcmp(list->arr[i],elem,list->itemSize)){
         return i;
     } 
    }
    return -1;
}
void* alist_remove(ArrayList* list, int index){
if(checkIndex(index,list->size)){
    void* returnVal=list->arr[index];
    for(int i=index+1;i<list->size;++i){
        list->arr[i-1]=list->arr[i];
    } 
    free(list->arr[list->size-1]);
    list->arr[list->size-1]=NULL;
    list->size--;
    return returnVal;
}else{
    return NULL;
}
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
 list->arr=realloc(list->arr,list->maxSize*sizeof(void*));
 return true;   
}

void printList(ArrayList* list){
printf("%s\n",list->type);
printf("%d\n",list->maxSize);
printf("%d\n",list->size);
printf("%d\n",list->itemSize);
}
void iterateAllElements(ArrayList* list){
int size=list->size;
for(int i=0;i<size;++i){
    printf("%d\n",*((int*)list->arr[i]));
}
}
void testMemcpy(){
    int a=1;
    //需要先对void进行分配内存
    void* fucker=malloc(sizeof(int));
    memcpy(fucker,&a,4);
    printf("%d",*(int*)fucker);
}
int main(){
    ArrayList* list=alist_initialize(10,4,"int");
    for(int i=0;i<100;i++){
        int pointer=i;
        alist_add(list,&pointer);
    }
    iterateAllElements(list);
      printList(list);
      int i=83333;
    alist_add_at(list,82,&i);
    iterateAllElements(list);
    // testMemcpy();
    printList(list);
    int j=94;
    printf("%d\n",alist_index_of(list,&j));
    printf("%d\n",*(int*)alist_get(list,83));
    printList(list);
    printf("%d\n",*(int*)alist_remove(list,6));
    printList(list);
    iterateAllElements(list);
    return 0;
}
