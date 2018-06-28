(function( $ ){
	$.fn.powerWebUpload = function (options) {
        var ele = this;
        if (typeof WebUploader == 'undefined') {
        
            var casspath = "static/js/plugins/webuploader-0.1.5/webuploader.css";
            $("<link>").attr({ rel: "stylesheet", type: "text/css", href: casspath }).appendTo("head");
            var jspath = "static/js/plugins/webuploader-0.1.5/webuploader.min.js";
            $.getScript(jspath) .done(function() {
                selectType(ele, options);
            })
            .fail(function() {
                alert("请检查webuploader的路径是否正确!")
            });
        }
        else {
        	selectType(ele, options);
        }
    }
	function selectType(ele, options){
		if(options.type=='file'){
			initWebUploadFile(ele, options);
		}else{
			initWebUpload(ele, options);
		}
	}
    // 当domReady的时候开始初始化
    function initWebUpload(item, options) {
    	 var pickerid = "";
         if (typeof guidGenerator36 != 'undefined'){//给一个唯一ID
             pickerid = guidGenerator36();
         }else{
             pickerid = (((1 + Math.random()) * 0x10000) | 0).toString(16).substring(1);
         }
	   	 var upload='<div class="queueList">'+
	     //'<div id="dndArea" class="placeholder">'+
	     '<div id="'+pickerid+'"></div>'+
	     //'<p>或将照片拖到这里，单次最多可选32220张</p>'+
	     //'</div>'+
	     '</div>'+
	     '<div class="statusBar" style="display:none;">'+
	     '<div class="progress">'+
	     '<span class="text">0%</span> <span class="percentage"></span>'+
	     '</div>'+
			'<div class="info"></div>'+
			'<div class="btns">'+
		    '<div id="'+pickerid+'2"></div>'
			'</div>'
		    '</div>'
		    $(item.selector).append(upload);
   	 
	   	 	var $wrap = $(item.selector),

            // 图片容器
            $queue = $( '<ul class="filelist"></ul>' )
                .appendTo( $wrap.find( '.queueList' ) ),

            // 状态栏，包括进度和控制按钮
            $statusBar = $wrap.find( '.statusBar' ),

            // 文件总体选择信息。
            $info = $statusBar.find( '.info' ),

            // 上传按钮
            $upload = $wrap.find( '.uploadBtn' ),

            // 没选择文件之前的内容。
            $placeHolder = $wrap.find( '.placeholder' ),

            $progress = $statusBar.find( '.progress' ).hide(),

            // 添加的文件数量
            fileCount = 0,

            // 添加的文件总大小
            fileSize = 0,

            // 优化retina, 在retina下这个值是2
            ratio = window.devicePixelRatio || 1,

            // 缩略图大小
            thumbnailWidth = 110 * ratio,
            thumbnailHeight = 110 * ratio,

            // 可能有pedding, ready, uploading, confirm, done.
            state = 'pedding',

            // 所有文件的进度信息，key为file id
            percentages = {},
            // 判断浏览器是否支持图片的base64
            isSupportBase64 = ( function() {
                var data = new Image();
                var support = true;
                data.onload = data.onerror = function() {
                    if( this.width != 1 || this.height != 1 ) {
                        support = false;
                    }
                }
                data.src = "data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///ywAAAAAAQABAAACAUwAOw==";
                return support;
            } )(),

            // 检测是否已经安装flash，检测flash的版本
            flashVersion = ( function() {
                var version;

                try {
                    version = navigator.plugins[ 'Shockwave Flash' ];
                    version = version.description;
                } catch ( ex ) {
                    try {
                        version = new ActiveXObject('ShockwaveFlash.ShockwaveFlash')
                                .GetVariable('$version');
                    } catch ( ex2 ) {
                        version = '0.0';
                    }
                }
                version = version.match( /\d+/g );
                return parseFloat( version[ 0 ] + '.' + version[ 1 ], 10 );
            } )(),

            supportTransition = (function(){
                var s = document.createElement('p').style,
                    r = 'transition' in s ||
                            'WebkitTransition' in s ||
                            'MozTransition' in s ||
                            'msTransition' in s ||
                            'OTransition' in s;
                s = null;
                return r;
            })(),

            // WebUploader实例
            uploader;

        if ( !WebUploader.Uploader.support('flash') && WebUploader.browser.ie ) {

            // flash 安装了但是版本过低。
            if (flashVersion) {
                (function(container) {
                    window['expressinstallcallback'] = function( state ) {
                        switch(state) {
                            case 'Download.Cancelled':
                                alert('您取消了更新！')
                                break;

                            case 'Download.Failed':
                                alert('安装失败')
                                break;

                            default:
                                alert('安装已成功，请刷新！');
                                break;
                        }
                        delete window['expressinstallcallback'];
                    };

                    var swf = 'expressInstall.swf';
                    // insert flash object
                    var html = '<object type="application/' +
                            'x-shockwave-flash" data="' +  swf + '" ';

                    if (WebUploader.browser.ie) {
                        html += 'classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" ';
                    }

                    html += 'width="100%" height="100%" style="outline:0">'  +
                        '<param name="movie" value="' + swf + '" />' +
                        '<param name="wmode" value="transparent" />' +
                        '<param name="allowscriptaccess" value="always" />' +
                    '</object>';

                    container.html(html);

                })($wrap);

            // 压根就没有安转。
            } else {
                $wrap.html('<a href="http://www.adobe.com/go/getflashplayer" target="_blank" border="0"><img alt="get flash player" src="http://www.adobe.com/macromedia/style_guide/images/160x41_Get_Flash_Player.jpg" /></a>');
            }

            return;
        } else if (!WebUploader.Uploader.support()) {
            alert( 'Web Uploader 不支持您的浏览器！');
            return;
        }

        // 实例化
        uploader = WebUploader.create({
            pick: {
                id: '#'+pickerid,
                label: '点击选择图片'
            },
            formData: {
            	type1:options.type,
                thumbWidth:100,
                thumbHeight:100
            },
            auto:true,
           // dnd: '#dndArea',
            paste: item.selector,
            swf: '../../dist/Uploader.swf',
            chunked: false,
            chunkSize: 512 * 1024,
            server: 'upload.html',
            // runtimeOrder: 'flash',

             accept: {
                 title: 'Images',
                 extensions: 'gif,jpg,jpeg,bmp,png',
                 mimeTypes: 'image/jpg,image/jpeg,image/png'
             },

            // 禁掉全局的拖拽功能。这样不会出现图片拖进页面的时候，把图片打开。
            disableGlobalDnd: false,
            fileNumLimit: options.fileNumLimit,
            fileSizeLimit: 200 * 1024 * 1024,    // 200 M
            fileSingleSizeLimit: 50 * 1024 * 1024    // 50 M
        });
        
        // 拖拽时不接受 js, txt 文件。
        uploader.on( 'dndAccept', function( items ) {
            var denied = false,
                len = items.length,
                i = 0,
                // 修改js类型
                unAllowed = 'text/plain;application/javascript ';

            for ( ; i < len; i++ ) {
                // 如果在列表里面
                if ( ~unAllowed.indexOf( items[ i ].type ) ) {
                    denied = true;
                    break;
                }
            }

            return !denied;
        });

        // uploader.on('filesQueued', function() {
        //     uploader.sort(function( a, b ) {
        //         if ( a.name < b.name )
        //           return -1;
        //         if ( a.name > b.name )
        //           return 1;
        //         return 0;
        //     });
        // });

        // 添加“添加文件”的按钮，
        uploader.addButton({
            id: '#'+pickerid+'2',
            label: '继续添加'
        });
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      	 //加载的时候，页面加载的时候模拟文件加入队列进行图片的编辑回显  
          uploader.on('ready',function(){  
       	   window.uploader = uploader;
              var id = $("#id").val();  
              if(typeof(id) == 'undefined'){  
                  return;  
              }  
              $.ajax({  
                  url:'filelist.html?ywId=' + id+'&ywType='+options.fileName ,//数据库获取文件信息  
                  type:'get',
                  dateType:'json',
                  async:false,  
                  success:function(files){
                      var files = eval('('+files+')');  
                      for(var i = 0; i < files.length; i++){ 
                   	   
                          var obj ={};  
                          statusMap = {};  
                          fileCount++;  
//                          fileSize += files[i].size;  
                          if ( fileCount === 1 ) {  
                              $placeHolder.addClass( 'element-invisible' );
                              $('#'+pickerid).hide();
                              $statusBar.show();
                          }  
                          obj.id=files[i].id;  
//                          alert(JSON.stringify(files[i]));
                          obj.name=files[i].realName; 
                          obj.sytype='update';
                          obj.sfileName=files[i].sfileName;
                          obj.type='123';
                          obj.rep=files[i].urlPath;
                          obj.urlSpath=files[i].urlSpath;
                          obj.ywId=files[i].ywId;
                          obj.ywType=files[i].ywType;
                          obj.descrption=files[i].descrption;
                          obj.fileAll=files[i];
                          obj.source=this;  
                          obj.flog=true;  
                          obj.status = 'complete',  
                          obj.getStatus = function(){  
                              return '';  
                          }  
//                          obj.version = WebUploader.Base.version;  
//                          obj.statusText = '';  
                          obj.setStatus = function(){  
                              var prevStatus = statusMap[this.id];  
                              typeof text !== 'undefined' && (this.statusText = text);  
                              if(status !== prevStatus){  
                                  statusMap[this.id] = status;  
                                  //文件状态设置为已完成  
                                  uploader.trigger('statuschage',status,prevStatus);  
                              }  
                          }  
                          addFile( obj);  
                          setState( 'ready' ,uploader,$queue,$statusBar);  
//                          updateStatus('ready',info,fileCount,fileSize);  
                      }
                  }  
              });  
          });  

     ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
//        uploader.on('ready', function() {
//            window.uploader = uploader;
//        });

        // 当有文件添加进来时执行，负责view的创建
        function addFile( file ) {
            var $li = $( '<li id="' + file.id + '">' +
                    '<p class="title">' + file.name + '</p>' +
                    '<p class="imgWrap"></p>'+
                    '</li>' ),

                $btns = $('<div class="file-panel" >' +
                    '<span class="cancel">删除</span>' +
                    '<span class="rotateRight">向右旋转</span>' +
                    '<span class="rotateLeft">向左旋转</span></div>').appendTo( $li ),
                $prgress = $li.find('p.progress span'),
                $wrap = $li.find( 'p.imgWrap' ),
                $info = $('<p class="error"></p>'),

                showError = function( code ) {
                    switch( code ) {
                        case 'exceed_size':
                            text = '文件大小超出';
                            break;

                        case 'interrupt':
                            text = '上传暂停';
                            break;

                        default:
                            text = '上传失败，请重试';
                            break;
                    }

                    $info.text( text ).appendTo( $li );
                };

            if ( file.getStatus() === 'invalid' ) {
                showError( file.statusText );
            } else {
                // @todo lazyload
                $wrap.text( '预览中' );
                uploader.makeThumb( file, function( error, src ) {
                    var img;
                    if(file.sytype=="update"){
                    	  var url="<a class='fancybox' href='"+path+file.rep+"' title='图片1'><img alt='image' src='"+path+file.urlSpath+"' /></a>"+
                    	  "<input name='"+options.fileName+"' type='hidden' value='"+JSON.stringify(file.fileAll)+"'>";
                          $wrap.empty().append( url );
                    }else{
                    if ( error ) {
                        $wrap.text( '不能预览' );
                        return;
                    }

                    if( isSupportBase64 ) {
                        img = $('<img src="'+src+'">');
                        
                        var url="<a class='fancybox' href='"+src+"' title='图片1'><img alt='image' src='"+src+"' /></a>";
                        
                        $wrap.empty().append( url );
                    } else {
                        $.ajax('../../server/preview.php', {
                            method: 'POST',
                            data: src,
                        }).done(function( response ) {
                            if (response.result) {
                                img = $('<img src="'+response.result+'">');
                                $wrap.empty().append( img );
                            } else {
                                $wrap.text("预览出错");
                            }
                        });
                    }
                    }
                }, thumbnailWidth, thumbnailHeight );

                percentages[ file.id ] = [ file.size, 0 ];
                file.rotation = 0;
            }

//            file.on('statuschange', function( cur, prev ) {
////                if ( prev === 'progress' ) {
////                    $prgress.hide().width(0);
////                } else if ( prev === 'queued' ) {
////                    $li.off( 'mouseenter mouseleave' );
////                    $btns.remove();
////                }
//
//                // 成功
//                if ( cur === 'error' || cur === 'invalid' ) {
//                    console.log( file.statusText );
//                    showError( file.statusText );
//                    percentages[ file.id ][ 1 ] = 1;
//                } else if ( cur === 'interrupt' ) {
//                    showError( 'interrupt' );
//                } else if ( cur === 'queued' ) {
//                    percentages[ file.id ][ 1 ] = 0;
//                } else if ( cur === 'progress' ) {
//                    $info.remove();
//                    $prgress.css('display', 'block');
//                } else if ( cur === 'complete' ) {
//                    $li.append( '<span class="success"></span>' );
//                }
//
//                $li.removeClass( 'state-' + prev ).addClass( 'state-' + cur );
//            });

            $li.on( 'mouseenter', function() {
                $btns.stop().animate({height: 30});
            });

            $li.on( 'mouseleave', function() {
                $btns.stop().animate({height: 0});
            });

            $btns.on( 'click', 'span', function() {
                var index = $(this).index(),
                    deg;

                switch ( index ) {
                    case 0:
                        uploader.removeFile( file );
                        return;

                    case 1:
                        file.rotation += 90;
                        break;

                    case 2:
                        file.rotation -= 90;
                        break;
                }

                if ( supportTransition ) {
                    deg = 'rotate(' + file.rotation + 'deg)';
                    $wrap.css({
                        '-webkit-transform': deg,
                        '-mos-transform': deg,
                        '-o-transform': deg,
                        'transform': deg
                    });
                } else {
                    $wrap.css( 'filter', 'progid:DXImageTransform.Microsoft.BasicImage(rotation='+ (~~((file.rotation/90)%4 + 4)%4) +')');
                }
            });

            $li.appendTo( $queue );
        }

        // 负责view的销毁
        function removeFile( file ) {
            var $li = $('#'+file.id);
            $info.html( "" );
            delete percentages[ file.id ];
            updateTotalProgress();
            $li.off().find('.file-panel').off().end().remove();
           if(fileCount<1){
        	   $('#'+pickerid).show();
           }
        }

        function updateTotalProgress() {
            var loaded = 0,
                total = 0,
                spans = $progress.children(),
                percent;

            $.each( percentages, function( k, v ) {
                total += v[ 0 ];
                loaded += v[ 0 ] * v[ 1 ];
            } );

            percent = total ? loaded / total : 0;


            spans.eq( 0 ).text( Math.round( percent * 100 ) + '%' );
            spans.eq( 1 ).css( 'width', Math.round( percent * 100 ) + '%' );
           
        }

        
        
        function setState( val ) {
            var file, stats;

            if ( val === state ) {
                return;
            }

            $upload.removeClass( 'state-' + state );
            $upload.addClass( 'state-' + val );
            state = val;

            switch ( state ) {
                case 'pedding':
                    $placeHolder.removeClass( 'element-invisible' );
                    $queue.hide();
                    $statusBar.addClass( 'element-invisible' );
                    uploader.refresh();
                    break;

                case 'ready':
                    $placeHolder.addClass( 'element-invisible' );
                    $( '#'+pickerid+'2' ).removeClass( 'element-invisible');
                    $queue.show();
                    $statusBar.removeClass('element-invisible');
                    uploader.refresh();
                    break;

                case 'uploading':
                    $( '#'+pickerid+'2' ).addClass( 'element-invisible' );
                    $progress.show();
                    $upload.text( '暂停上传' );
                    break;

                case 'paused':
                    $progress.show();
                    $upload.text( '继续上传' );
                    break;

                case 'confirm':
                    $progress.hide();
                    $( '#'+pickerid+'2' ).removeClass( 'element-invisible' );
                    $upload.text( '' );

                    stats = uploader.getStats();
                    if ( stats.successNum && !stats.uploadFailNum ) {
                        setState( 'finish' );
                        return;
                    }
                    break;
                case 'finish':
                    stats = uploader.getStats();
                    if ( stats.successNum ) {
                       // alert( '上传成功' );
                    } else {
                        // 没有成功的图片，重设
                        state = 'done';
                        location.reload();
                    }
                    break;
            }

          
        }

        uploader.onUploadProgress = function( file, percentage ) {
            var $li = $('#'+file.id),
                $percent = $li.find('.progress span');

            $percent.css( 'width', percentage * 100 + '%' );
            percentages[ file.id ][ 1 ] = percentage;
            updateTotalProgress();
        };

        uploader.onFileQueued = function( file ) {
            fileCount++;
            fileSize += file.size;
            
            if ( fileCount === 1 ) {
                $placeHolder.addClass( 'element-invisible' );
                $('#'+pickerid).hide();
                $statusBar.show();
            }

            addFile( file );
            setState( 'ready' );
            updateTotalProgress();
        };

        uploader.onFileDequeued = function( file ) {
            fileCount--;
            fileSize -= file.size;

            if ( !fileCount ) {
                setState( 'pedding' );
            }

            removeFile( file );
            updateTotalProgress();

        };
      //自己加的成功函数
        uploader.on( 'uploadSuccess', function( file, response ) {
        	
        	var img=JSON.parse(response.message);
        	$info.html( "" );
        	//$("#"+file.id).append("<input name='"+options.fileName+"' type='text' value='"+img+"'>");item.selector
        	$(item.selector).find('#'+file.id).append("<input name='"+options.fileName+"' type='text' value='"+response.message+"'>");
        	$(item.selector).find('#'+file.id+' a').attr("href",path+img.urlPath);
         });
        //======================函数结束========================================

        uploader.on( 'all', function( type ) {
            var stats;
            switch( type ) {
                case 'uploadFinished':
                    setState( 'confirm' );
                    break;

                case 'startUpload':
                    setState( 'uploading' );
                    break;

                case 'stopUpload':
                    setState( 'paused' );
                    break;

            }
        });

        uploader.onError = function( code ) {
        	//alert(code);
        	var text="";
        	if(code!=null && code!=''){
	        	if(code=='Q_EXCEED_NUM_LIMIT'){
	        		text="最多只能上传"+options.fileNumLimit+"张图片";
	            }else if(code=='Q_EXCEED_SIZE_LIMIT'){
	            	text="‘件大小超出限制";
	            }else if(code=='Q_TYPE_DENIED'){
	            	text="上传文件类型不符";
	            } else if(code=='F_DUPLICATE'){
	            	text="列表中已经存在";
	            } else {
	            	text="未知错误";
	            } 
	        	alert( '错误：' + text );
	        	
        	}else{
        		code=null ;
        		text="" ;
        	}
        	$info.html( text );
        };

        $upload.on('click', function() {
            if ( $(this).hasClass( 'disabled' ) ) {
                return false;
            }

            if ( state === 'ready' ) {
                uploader.upload();
            } else if ( state === 'paused' ) {
                uploader.upload();
            } else if ( state === 'uploading' ) {
                uploader.stop();
            }
        });

        $info.on( 'click', '.retry', function() {
            uploader.retry();
        } );

        $info.on( 'click', '.ignore', function() {
            alert( 'todo' );
        } );

        $upload.addClass( 'state-' + state );
        updateTotalProgress();
    };
    //文件上传方法
    function initWebUploadFile(item, options) {

        if (!WebUploader.Uploader.support()) {
            var error = "上传控件不支持您的浏览器！请尝试升级flash版本或者使用Chrome引擎的浏览器。<a target='_blank' href='http://se.360.cn'>下载页面</a>";
            if (window.console) {
                window.console.log(error);
            }
            $(item).text(error);
            return;
        }
        //创建默认参数
        var defaults = {
            auto:true,
            hiddenInputId: "uploadifyHiddenInputId", // input hidden id
            onAllComplete: function (event) { }, // 当所有file都上传后执行的回调函数
            onComplete: function (event) { },// 每上传一个file的回调函数
            innerOptions: {},
            fileNumLimit: undefined,//验证文件总数量, 超出则不允许加入队列
            fileSizeLimit: undefined,//验证文件总大小是否超出限制, 超出则不允许加入队列。
            fileSingleSizeLimit: undefined,//验证单个文件大小是否超出限制, 超出则不允许加入队列
            PostbackHold: false
        };
        var opts = $.extend(defaults, options);
        var hdFileData = $("#" + opts.hiddenInputId);
        var target = $(item);//容器
        var pickerid = "";
        if (typeof guidGenerator36 != 'undefined')//给一个唯一ID
            pickerid = guidGenerator36();
        else
            pickerid = (((1 + Math.random()) * 0x10000) | 0).toString(16).substring(1);
        var uploaderStrdiv = '<div class="webuploader">'
        //debugger
        if (opts.auto) {
            uploaderStrdiv = 
            '<div id="Uploadthelist" class="uploader-list"></div>' +
            '<div class="btns">' +
            '<div id="' + pickerid + '">选择文件</div>' +
            '</div>'

        } else {
            uploaderStrdiv = 
            '<div  class="uploader-list"></div>' +
            '<div class="btns">' +
            '<div id="' + pickerid + '">选择文件</div>' +
            '<button class="webuploadbtn">开始上传</button>' +
            '</div>'
        }
        uploaderStrdiv += '<div style="display:none" class="UploadhiddenInput" >\
                         </div>'
        uploaderStrdiv+='</div>';
        target.append(uploaderStrdiv);

        var $list = target.find('.uploader-list'),
             $btn = target.find('.webuploadbtn'),//手动上传按钮备用
             state = 'pending',
             $hiddenInput = target.find('.UploadhiddenInput'),
             uploader;
        var jsonData = {
            fileList: []
        };

        var webuploaderoptions = $.extend({

            // swf文件路径
            swf: 'Uploader.swf',
            // 文件接收服务端。
            server:  'upload.html',
            deleteServer:'/Home/DeleteFile',
            // 选择文件的按钮。可选。
            // 内部根据当前运行是创建，可能是input元素，也可能是flash.
            pick: '#' + pickerid,
            //不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
            resize: false,
            fileNumLimit: opts.fileNumLimit,
            fileSizeLimit: opts.fileSizeLimit,
            fileSingleSizeLimit: opts.fileSingleSizeLimit
        },
        opts.innerOptions);
        var uploader = WebUploader.create(webuploaderoptions);

        //回发时还原hiddenfiled的保持数据
        var fileDataStr = hdFileData.val();
        if (fileDataStr && opts.PostbackHold) {
            jsonData = JSON.parse(fileDataStr);
            $.each(jsonData.fileList, function (index, fileData) {
                var newid = SuiJiNum();
                fileData.queueId = newid;
                $list.append('<div id="' + newid + '" class="item">' +
                '<div class="info">' + fileData.name + '</div>' +
                '<div class="state">已上传</div>' +
                '<div class="del"></div>' +
                '</div>');
            });
            hdFileData.val(JSON.stringify(jsonData));
        }



        if (opts.auto) {
            
            uploader.on('fileQueued', function (file) {
                //debugger;
                $list.append('<div id="' + $(item)[0].id + file.id + '" class="item">' +
                   '<span class="webuploadinfo">' + file.name + '</span>' +
                   '<span class="webuploadstate">正在上传...</span>' +
                   '<div class="webuploadDelbtn">删除</div><br />' +
               '</div>');
                uploader.upload();
            });
        } else {
            uploader.on('fileQueued', function (file) {//队列事件
                $list.append('<div id="' + $(item)[0].id + file.id + '" class="item">' +
                    '<span class="webuploadinfo">' + file.name + '</span>' +
                    '<span class="webuploadstate">等待上传...</span>' +
                    '<div class="webuploadDelbtn">删除</div><br />' +
                '</div>');
            });
        }
       
        
        uploader.on('uploadProgress', function (file, percentage) {//进度条事件
            var $li = target.find('#' + $(item)[0].id + file.id),
                $percent = $li.find('.progress .bar');

            // 避免重复创建
            if (!$percent.length) {
                $percent = $('<span class="progress">' +
                    '<span  class="percentage"><span class="text"></span>' +
                  '<span class="bar" role="progressbar" style="width: 0%">' +
                  '</span></span>' +
                '</span>').appendTo($li).find('.bar');
            }

            $li.find('span.webuploadstate').html('上传中');
            $li.find(".text").text(Math.round(percentage * 100) + '%');
            $percent.css('width', percentage * 100 + '%');
        });
        uploader.on('uploadSuccess', function (file, response) {//上传成功事件
            //debugger
            if (response.state == "error") {
                target.find('#' + $(item)[0].id + file.id).find('span.webuploadstate').html(response.message);
            } else {
                target.find('#' + $(item)[0].id + file.id).find('span.webuploadstate').html('已上传');
                $hiddenInput.append('<input type="text" id="hiddenInput'+$(item)[0].id + file.id + '" class="hiddenInput" value="' + response.message + '" />')
            }


        });

        uploader.on('uploadError', function (file) {
            target.find('#' + $(item)[0].id + file.id).find('span.webuploadstate').html('上传出错');
        });

        uploader.on('uploadComplete', function (file) {//全部完成事件
            target.find('#' + $(item)[0].id + file.id).find('.progress').fadeOut();

        });

        uploader.on('all', function (type) {
            if (type === 'startUpload') {
                state = 'uploading';
            } else if (type === 'stopUpload') {
                state = 'paused';
            } else if (type === 'uploadFinished') {
                state = 'done';
            }

            if (state === 'uploading') {
                $btn.text('暂停上传');
            } else {
                $btn.text('开始上传');
            }
        });

        //删除时执行的方法
        uploader.on('fileDequeued', function (file) {
            //debugger
            
            var fullName = $("#hiddenInput" + $(item)[0].id + file.id).val();
            if (fullName!=null) {
                $.post(webuploaderoptions.deleteServer, { fullName: fullName }, function (data) {
                    //alert(data.message);
                })
            }
            $("#"+ $(item)[0].id + file.id).remove();
            $("#hiddenInput" + $(item)[0].id + file.id).remove();
            
        })

        //多文件点击上传的方法
        $btn.on('click', function () {
            if (state === 'uploading') {
                uploader.stop();
            } else {
                uploader.upload();
            }
        });

        //删除
        $list.on("click", ".webuploadDelbtn", function () {
            //debugger
            var $ele = $(this);
            var id = $ele.parent().attr("id");
            var id = id.replace($(item)[0].id, "");

            var file = uploader.getFile(id);
            uploader.removeFile(file);
        });

    }
    $("img").mouseover(function(){
    	//此位置禁止加入弹出框
    	$(".file-panel").show();
    	
    	});
    
})( jQuery );