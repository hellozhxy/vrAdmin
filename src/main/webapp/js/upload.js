function contains(arr, obj) {  
    	    var i = arr.length;  
    	    while (i--) {  
    	        if (arr[i] === obj) {  
    	            return true;  
    	        }  
    	    }  
    	    return false;  
    	}
      	
      	function fileSuffix(fileName){
      		if(fileName.lastIndexOf(".") != -1){
      			return fileName.substring(fileName.lastIndexOf(".")+1);
      		}
      		return null;
      	}
      
        var r = new Resumable({
            target:'/resource/upload',
            chunkSize:1*1024*1024,
            simultaneousUploads:4,
            testChunks: false,
            throttleProgressCallbacks:1,
            method: "octet"
          });
        // Resumable.js isn't supported, fall back on a different method
        if(!r.support) {
          $('.resumable-error').show();
        } else {
          // Show a place for dropping/selecting files
          $('.resumable-drop').show();
          r.assignDrop($('.resumable-drop')[0]);
          r.assignBrowse($('.resumable-browse')[0]);

          // Handle file add event
          r.on('fileAdded', function(file){
        	  var validFileSuffix = new Array("avi","rmvb","rm","asf","divx","mpg","mpeg","mpe","wmv","mp4","mkv","vob");
              if(!contains(validFileSuffix, fileSuffix(file.fileName))){
            	  alert("上传文件不合法!");
            	  return 
              }
              // Show progress pabr
              $('.resumable-progress, .resumable-list').show();
              // Show pause, hide resume
              $('.resumable-progress .progress-resume-link').hide();
              $('.resumable-progress .progress-pause-link').show();
              // Add the file to the list
              $('.resumable-list').append(Math.floor(r.progress()*100) + '%')
              //$('.resumable-list').append('<li class="resumable-file-'+file.uniqueIdentifier+'">Uploading <span class="resumable-file-name"></span> <span class="resumable-file-progress"></span>');
              //$('.resumable-file-'+file.uniqueIdentifier+' .resumable-file-name').html(file.fileName);
              // Actually start the upload
              r.upload();
            });
          r.on('pause', function(){
              // Show resume, hide pause
              $('.resumable-progress .progress-resume-link').show();
              $('.resumable-progress .progress-pause-link').hide();
            });
          r.on('complete', function(){
        	  alert("文件上传成功!");
              // Hide pause/resume when the upload has completed
              $('.resumable-progress .progress-resume-link, .resumable-progress .progress-pause-link').hide();
              $('.resumable-list').empty();
            });
          r.on('fileSuccess', function(file,message){
              // Reflect that the file upload has completed
              $('.resumable-file-'+file.uniqueIdentifier+' .resumable-file-progress').html('(completed)');
            });
          r.on('fileError', function(file, message){
              // Reflect that the file upload has resulted in error
              $('.resumable-file-'+file.uniqueIdentifier+' .resumable-file-progress').html('(file could not be uploaded: '+message+')');
            });
          r.on('fileProgress', function(file){
              // Handle progress for both the file and the overall upload
              $('.resumable-file-'+file.uniqueIdentifier+' .resumable-file-progress').html(Math.floor(file.progress()*100) + '%');
              $('.progress-bar').css({width:Math.floor(r.progress()*100) + '%'});
              //console.log(Math.floor(r.progress()*100) + '%');
              $('.resumable-list').html(Math.floor(r.progress()*100) + '%');
            });
        }