#include<stdio.h>



#define MAX_SIZE (1024 * 1024 * 6 )

int main(){
  FILE *fptr;
  char data[MAX_SIZE];
  fptr = fopen("myFile" , "rb");
  
  int i = 0;
  while(!feof(fptr)){
    data[i++] = fgetc(fptr);
  }
  fclose(fptr);


  fptr = fopen("myFile" , "wb");
  for(int j = 0 ; j < i-1 ; j++)
      fputc((data[j]^ 0x60) ,fptr);
  fclose(fptr);
  return 0;
}
